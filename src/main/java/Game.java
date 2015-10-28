import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by bkerl on 28/10/15.
 */
public class Game {

    private Frame currentFrame = new Frame();

    private LinkedList<Frame> frames = new LinkedList<Frame>();

    void roll(int pins) {
        currentFrame.roll(pins);
        if (currentFrame.isCompleted()){
            frames.add(currentFrame);
            currentFrame = new Frame();
        }
    }

    int score() {
        int totalScore = 0;
        for (Frame frame : frames) {
            totalScore += frame.score();
        }
        totalScore += currentFrame.score();
        return totalScore;
    }
}
