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
            frames.add(currentFrame);
            currentFrame = new Frame();
        }
    }

    int score() {
        int totalScore = 0;
        Frame previousGame = new Frame();
        for (Frame frame : frames) {
            totalScore += frame.score();
            totalScore = calculateTotalScore(totalScore, previousGame, frame);
            previousGame = frame;
        }
        if (currentFrame.isInProgress()){
            totalScore += currentFrame.score();
            totalScore = calculateTotalScore(totalScore, previousGame, currentFrame);
        }
        return totalScore;
    }

    private int calculateTotalScore(int totalScore, Frame previousGame, Frame frame) {
        if (previousGame.isSpare()) {
            totalScore += frame.scoreFirstThrow();
        }
        return totalScore;
    }

}
