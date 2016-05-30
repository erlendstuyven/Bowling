import java.util.*;

/**
 * Created by bkerl on 28/10/15.
 */
public class Game {

    private Frame currentFrame = new Frame();

    private Set<Frame> frames = new LinkedHashSet<Frame>();

    void roll(int pins) {
        currentFrame.roll(pins);
        addCurrentFrameWhenCompleted();
    }

    private void addCurrentFrameWhenCompleted() {
        frames.add(currentFrame);
        if (currentFrame.isCompleted()){
            currentFrame = new Frame();
        }
    }

    int score() {
        int totalScore = 0;
        Frame previousFrame = new Frame();
        for (Frame frame : frames) {
            totalScore += frame.score();
            if (previousFrame.isSpare()) {
                totalScore += frame.scoreFirstThrow();
            }
            previousFrame = frame;
        }
        return totalScore;
    }

}
