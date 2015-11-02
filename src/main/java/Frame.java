import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by bkerl on 27/10/15.
 */

public class Frame {
    private int firstThrow = -1;
    private int secondThrow = -1;

    Frame() {
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
            return firstThrow;
        }
        return firstThrow + secondThrow;
    }

    public boolean isSpare() {
        return firstThrow + secondThrow == 10 && firstThrow != 10;
    }

    public boolean isStrike() {
        return firstThrow == 10;
    }

    public boolean isCompleted() {
        return isStrike() || (firstThrow > -1 && secondThrow > -1);
    }

    public boolean isInProgress() {
        return !isCompleted() && firstThrow > -1;
    }
}
