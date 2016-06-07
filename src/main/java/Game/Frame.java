package Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class Frame {

    private List<Roll> rolls = getRolls();

    abstract ArrayList<Roll> getRolls();

    private Frame previousFrame;

    Frame(){}

    Frame(Frame previousFrame) {
        this.previousFrame = previousFrame;
    }

    abstract int getMaximumNumberOfRolls();

    void roll(int pins) {
        Optional<Roll> firstRollAvailableForPins = rolls.stream().filter(roll -> !roll.isThrown()).findFirst();
        if (firstRollAvailableForPins.isPresent()) {
            firstRollAvailableForPins.get().setPins(pins);
        } else {
            throw new IllegalStateException("You can maximum throw " + getMaximumNumberOfRolls() + " a frame.");
        }
   }

    int score() {
        if (!firstRoll().isThrown()) {
            throw new IllegalStateException("There need to be at least one roll for a Frame.");
        }
        int totalPinsDown = calculatePinsDown();
        totalPinsDown = calculateBonusPinsWhenSpare(totalPinsDown);
        totalPinsDown = calculateBonusPinsWhenStrike(totalPinsDown);
        return totalPinsDown;
    }

    boolean isCompleted() {
        return isStrike() || (firstRoll().isThrown() && secondRoll().isThrown());
    }

    private int calculatePinsDown() {
        return rolls.stream().filter(roll -> roll.isThrown()).mapToInt(roll -> roll.getPins()).sum();
    }

    private int calculateBonusPinsWhenStrike(int totalPinsDown) {
        if (previousFrame.isStrike()){
                totalPinsDown = totalPinsDown * 2;
            }
        return totalPinsDown;
    }

    private int calculateBonusPinsWhenSpare(int totalPinsDown) {
        if (previousFrame.isSpare()) {
            totalPinsDown = totalPinsDown + firstRoll().getPins();
        }
        return totalPinsDown;
    }

    private boolean isSpare() {
        return (firstRoll().getPins() + secondRoll().getPins() == 10) && !firstRoll().hasTenPinsDown();
    }

    private boolean isStrike() {
        return firstRoll().hasTenPinsDown();
    }

    private Roll firstRoll() {
        return rolls.get(0);
    }

    private Roll secondRoll() {
        return rolls.get(1);
    }

}
