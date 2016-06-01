package Game;

import java.util.LinkedHashSet;
import java.util.function.Function;

public class Game {

    public static final int MAX_NUMBER_OF_FRAMES_IN_A_GAME = 10;
    private LinkedHashSet<Frame> frames = new LinkedHashSet<Frame>();

    private Frame currentFrame = new Frame(new Frame());

    public Game() {
    }

    public void roll(int pins) {
        validateNumberOfFramesIsLessThan(MAX_NUMBER_OF_FRAMES_IN_A_GAME);
        currentFrame.roll(pins);
        frames.add(currentFrame);
        startNewFrameWhenCurrentIsCompleted();
    }

    public int score() {
        return frames.stream().map(toScore()).mapToInt(Integer::intValue).sum();
    }

    private Function<Frame, Integer> toScore() {
        return new Function<Frame, Integer>() {
            @Override
            public Integer apply(Frame frame) {
                return frame.score();
            }
        };
    }

    private void validateNumberOfFramesIsLessThan(int maxNumberOfFrames) {
        if (frames.size() == maxNumberOfFrames && !frames.contains(currentFrame)){
            throw new IllegalStateException("Number of frames can not be greater than 10");
        }
    }

    private void startNewFrameWhenCurrentIsCompleted() {
        if (currentFrame.isCompleted()){
            currentFrame = new Frame(currentFrame);
        }
    }

}
