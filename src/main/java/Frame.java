public class Frame {

    private Throw firstThrow = new Throw();
    private Throw secondThrow = new Throw();

    private Frame previousFrame;

    Frame(){}

    Frame(Frame previousFrame) {
        this.previousFrame = previousFrame;
    }

    void roll(int pins) {
        if (!firstThrow.isThrown()) {
            firstThrow.setPins(pins);
        } else if (!secondThrow.isThrown()) {
            secondThrow.setPins(pins);
        } else {
            throw new IllegalStateException("You can maximum throw twice a frame.");
        }
    }

    int score() {
        if (!firstThrow.isThrown()) {
            throw new IllegalStateException("There need to be at least one throw for a Frame.");
        }
        int total = firstThrow.getPins();
        if (secondThrow.isThrown()) {
            total = total + secondThrow.getPins();
        }
        if (previousFrame.isSpare() || previousFrame.isStrike()) {
            total = total + firstThrow.getPins();
        }
        if (previousFrame.isStrike()){
            if (secondThrow.isThrown()) {
                total = total + secondThrow.getPins();
            }
        }
        return total;
    }

    boolean isCompleted() {
        return isStrike() || (firstThrow.isThrown() && secondThrow.isThrown());
    }

    private boolean isSpare() {
        return firstThrow.getPins() + secondThrow.getPins() == 10 && firstThrow.getPins() != 10;
    }

    private boolean isStrike() {
        return firstThrow.getPins() == 10;
    }

    private boolean isThrown(int aThrow) {
        return aThrow > -1;
    }
}
