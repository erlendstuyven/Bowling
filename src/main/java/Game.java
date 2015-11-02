import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;

/**
 * Created by bkerl on 28/10/15.
 */
public class Game {

    private Frame currentFrame = new Frame();

    private LinkedList<Frame> frames = new LinkedList<Frame>();

    void roll(int pins) {
        currentFrame.roll(pins);
        if (currentFrame.isCompleted()){
            completeFrame();
        }
    }

    int score() {
        int totalScore = 0;
        for (Frame frame : frames) {
            totalScore += frame.score();
        }
        if (currentFrame.isInProgress()){
            totalScore += currentFrame.score();
        }
        return totalScore;
    }

    private void completeFrame() {
        frames.add(currentFrame);
        currentFrame = new Frame();
    }

}
