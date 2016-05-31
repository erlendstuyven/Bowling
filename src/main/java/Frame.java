public class Frame {
    private int firstThrow = -1;
    private int secondThrow = -1;
    private Frame previousFrame;

    Frame(){}

    Frame(Frame previousFrame) {
        this.previousFrame = previousFrame;
    }

    void roll(int pins) {
        if (isNotThrown(firstThrow)) {
            firstThrow = pins;
        } else if (isNotThrown(secondThrow)) {
            secondThrow = pins;
        } else {
            throw new IllegalStateException("You can maximum throw twice a frame.");
        }
    }

    int score() {
        if (isNotThrown(firstThrow)) {
            throw new IllegalStateException("There need to be at least one throw for a Frame.");
        }
        if (isNotThrown(secondThrow)) {
            if (previousFrame.isSpare()){
                return doubleThrow(firstThrow);
            }
            return firstThrow;
        }
        if (previousFrame.isSpare()) {
            return doubleThrow(firstThrow) + secondThrow;
        }
        return firstThrow + secondThrow;
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

    private boolean isNotThrown(int aThrow) {
        return aThrow == -1;
    }
}
