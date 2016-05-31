public class Frame {
    private int firstThrow = -1;
    private int secondThrow = -1;
    private Frame previousFrame;

    Frame(){}

    Frame(Frame previousFrame) {
        this.previousFrame = previousFrame;
    }

    void roll(int pins) {
        if (!isThrown(firstThrow)) {
            firstThrow = pins;
        } else if (!isThrown(secondThrow)) {
            secondThrow = pins;
        } else {
            throw new IllegalStateException("You can maximum throw twice a frame.");
        }
    }

    int score() {
        if (!isThrown(firstThrow)) {
            throw new IllegalStateException("There need to be at least one throw for a Frame.");
        }
        int total = firstThrow;
        if (isThrown(secondThrow)) {
            total = total + secondThrow;
        }
        if (previousFrame.isSpare()) {
            total = total + firstThrow;
        }
        if (previousFrame.isStrike()){
            total = total + firstThrow;
            if (isThrown(secondThrow)) {
                total = total + secondThrow;
            }
        }
        return total;
    }

    boolean isCompleted() {
        return isStrike() || (firstThrow > -1 && secondThrow > -1);
    }

    private boolean isSpare() {
        return firstThrow + secondThrow == 10 && firstThrow != 10;
    }

    private boolean isStrike() {
        return firstThrow == 10;
    }

    private int doubleThrow(int aThrow) {
        return aThrow * 2;
    }

    private boolean isThrown(int aThrow) {
        return aThrow > -1;
    }
}
