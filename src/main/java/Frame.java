import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by bkerl on 27/10/15.
 */

public class Frame {
    private int firstThrow = -1;
    private int secondThrow = -1;
    private Frame previousFrame;

    Frame() {
    }

    Frame(Frame previousFrame) {
        this.previousFrame = previousFrame;
    }

    void roll(int pins) {
        if (firstThrow == -1) {
            firstThrow = pins;
        } else if (secondThrow == -1) {
            secondThrow = pins;
        } else {
            throw new IllegalStateException("You can maximum throw twice a frame.");
        }
    }

    int score() {
        if (firstThrow == -1) {
            throw new IllegalStateException("There need to be at least one throw for a Frame.");
        }
        if (secondThrow == -1) {
            if (previousFrame.isSpare()){
                return firstThrow + firstThrow;
            }
            return firstThrow;
        }
        if (previousFrame.isSpare()) {
            return firstThrow + firstThrow + secondThrow;
        }
        return firstThrow + secondThrow;
    }

 //   int scoreFirstThrow() {
 //       if (firstThrow == -1) {
 //           throw new IllegalStateException("There need to be at least one throw for a Frame.");
 //       }
 //       return firstThrow;
 //   }

    boolean isSpare() {
        return firstThrow + secondThrow == 10 && firstThrow != 10;
    }

    boolean isStrike() {
        return firstThrow == 10;
    }

    boolean isNormal() { return !isSpare() && !isStrike(); }

    boolean isCompleted() {
        return isStrike() || (firstThrow > -1 && secondThrow > -1);
    }

    boolean isInProgress() {
        return !isCompleted() && firstThrow > -1;
    }

    Status getStatus() {
        Status statusPreviousGame = Status.NORMAL;
        if (isSpare()) {
            statusPreviousGame = Status.SPARE;
        } else if (isStrike()) {
            statusPreviousGame = Status.STRIKE;
        }
        return statusPreviousGame;
    }

    enum Status {
        NORMAL,
        SPARE,
        STRIKE
    }

    boolean isStarted() {
        return firstThrow > -1;
    }

}
