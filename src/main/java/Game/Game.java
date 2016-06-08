package Game;

import java.util.LinkedHashSet;

public class Game {

    public static final int MAX_NUMBER_OF_FRAMES_IN_A_GAME = 10;
    private LinkedHashSet<Frame> frames = new LinkedHashSet<Frame>();

    private NormalFrame currentFrame = new NormalFrame(new NormalFrame());

    public Game() {
    }

    public void roll(int pins) {
        validateNumberOfFramesIsLessThan(MAX_NUMBER_OF_FRAMES_IN_A_GAME);
        currentFrame.roll(pins);
        frames.add(currentFrame);
        startNewFrameWhenCurrentIsCompleted();
    }

    public int score() {
       return frames.stream().map(frame -> frame.score()).mapToInt(Integer::intValue).sum();
    }

    private void validateNumberOfFramesIsLessThan(int maxNumberOfFrames) {
        if (frames.size() == maxNumberOfFrames && !frames.contains(currentFrame)){
            throw new IllegalStateException("Number of frames can not be greater than 10");
        }
    }

    private void startNewFrameWhenCurrentIsCompleted() {
        if (currentFrame.isCompleted()){
            if (frames.size() == MAX_NUMBER_OF_FRAMES_IN_A_GAME) {
                currentFrame = new NormalFrame(currentFrame);
            } else {
                currentFrame = new NormalFrame(currentFrame);
            }
        }
    }

}
