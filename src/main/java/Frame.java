public class Frame {

    private Roll firstRoll = new Roll();
    private Roll secondRoll = new Roll();

    private Frame previousFrame;

    Frame(){}

    Frame(Frame previousFrame) {
        this.previousFrame = previousFrame;
    }

    void roll(int pins) {
        if (!firstRoll.isThrown()) {
            firstRoll.setPins(pins);
        } else if (!secondRoll.isThrown()) {
            secondRoll.setPins(pins);
        } else {
            throw new IllegalStateException("You can maximum throw twice a frame.");
        }
    }

    int score() {
        if (!firstRoll.isThrown()) {
            throw new IllegalStateException("There need to be at least one throw for a Frame.");
        }
        int total = firstRoll.getPins();
        if (secondRoll.isThrown()) {
            total = total + secondRoll.getPins();
        }
        if (previousFrame.isSpare() || previousFrame.isStrike()) {
            total = total + firstRoll.getPins();
        }
        if (previousFrame.isStrike()){
            if (secondRoll.isThrown()) {
                total = total + secondRoll.getPins();
            }
        }
        return total;
    }

    boolean isCompleted() {
        return isStrike() || (firstRoll.isThrown() && secondRoll.isThrown());
    }

    private boolean isSpare() {
        return (firstRoll.getPins() + secondRoll.getPins() == 10) && !firstRoll.hasTenPinsDown();
    }

    private boolean isStrike() {
        return firstRoll.hasTenPinsDown();
    }

}
