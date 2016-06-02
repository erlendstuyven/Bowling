package Game;

import java.util.ArrayList;
import java.util.List;

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
        int counter = 0;
        while (counter < getMaximumNumberOfRolls()) {
            if (!rolls.get(counter).isThrown()){
                rolls.get(counter).setPins(pins);
                break;
            }
            counter++;
        }
        if (counter == getMaximumNumberOfRolls()) {
            throw new IllegalStateException("You can maximum throw twice a frame.");
        }
   }

    int score() {
        if (!firstRoll().isThrown()) {
            throw new IllegalStateException("There need to be at least one throw for a Game.Frame.");
        }
        int total = firstRoll().getPins();
        if (secondRoll().isThrown()) {
            total = total + secondRoll().getPins();
        }
        if (previousFrame.isSpare() || previousFrame.isStrike()) {
            total = total + firstRoll().getPins();
        }
        if (previousFrame.isStrike()){
            if (secondRoll().isThrown()) {
                total = total + secondRoll().getPins();
            }
        }
        return total;
    }

    boolean isCompleted() {
        return isStrike() || (firstRoll().isThrown() && secondRoll().isThrown());
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
