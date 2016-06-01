package Game;

import java.util.LinkedHashSet;
import java.util.function.Function;

public class Game {

    private LinkedHashSet<Frame> frames = new LinkedHashSet<Frame>();

    private Frame currentFrame = new Frame(new Frame());

    public Game() {
    }

    public void roll(int pins) {
        validateNumberOfFramesIsMaximumTen();
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

    private void validateNumberOfFramesIsMaximumTen() {
        if (frames.size() == 10 && !frames.contains(currentFrame)){
            throw new IllegalStateException("Number of frames can not be greater than 10");
        }
    }

    private void startNewFrameWhenCurrentIsCompleted() {
        if (currentFrame.isCompleted()){
            currentFrame = new Frame(currentFrame);
        }
    }

}
