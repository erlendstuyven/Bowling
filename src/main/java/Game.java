import java.util.*;

public class Game {

    private LinkedHashSet<Frame> frames = new LinkedHashSet<Frame>();

    private Frame currentFrame = new Frame(new Frame());

    void roll(int pins) {
        currentFrame.roll(pins);
        frames.add(currentFrame);
        startNewFrameWhenCurrentIsCompleted();
    }

    private void startNewFrameWhenCurrentIsCompleted() {
        if (currentFrame.isCompleted()){
            currentFrame = new Frame(currentFrame);
        }
    }

    int score() {
        int totalScore = 0;
        for (Frame frame : frames) {
            totalScore += frame.score();
        }
        return totalScore;
    }

}
