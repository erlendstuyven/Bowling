package Game;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FrameTest {

    private NormalFrame frame = new NormalFrame(new NormalFrame());
    private NormalFrame spareFrame;
    private NormalFrame strikeFrame;

    @Before
    public void setUp() throws Exception {
        spareFrame = new NormalFrame();
        spareFrame.roll(1);
        spareFrame.roll(9);
        strikeFrame = new NormalFrame();
        strikeFrame.roll(10);
    }

    @Test (expected = IllegalStateException.class)
    public void testScoreWithoutRolls() throws Exception {
        frame.score();
    }

    @Test
    public void testRollTwoThrows() throws Exception {
        frame.roll(3);
        frame.roll(4);
        assertThat(frame.score()).isEqualTo(7);
    }

    @Test
    public void testRollOneThrow() throws Exception {
        frame.roll(10);
        assertThat(frame.score()).isEqualTo(10);
    }

    @Test(expected = IllegalStateException.class)
    public void testRollZeroThrowsGivesIllegalStateException() throws Exception {
        frame.score();
    }

    @Test (expected = IllegalStateException.class)
    public void rollThreeTimesGivesIllegalStateException() throws Exception {
        frame.roll(3);
        frame.roll(4);
        frame.roll(5);
    }

    @Test
    public void isSpareTwoThrowsAndSumIs10() throws Exception {
        frame.roll(3);
        frame.roll(7);
        assertThat(frame.score()).isEqualTo(10);
    }

    @Test
    public void isCompletedWhenFirstThrowIs10() throws Exception {
        frame.roll(10);
        assertThat(frame.isCompleted()).isTrue();
    }

    @Test
    public void scoreDoublesFirstThrowTWhenPreviousFrameIsSpare() throws Exception {
        Frame frameWithPreviousFrameIsSpare = new NormalFrame(spareFrame);
        frameWithPreviousFrameIsSpare.roll(2);
        assertThat(frameWithPreviousFrameIsSpare.score()).isEqualTo(4);
        frameWithPreviousFrameIsSpare.roll(3);
        assertThat(frameWithPreviousFrameIsSpare.score()).isEqualTo(7);
    }

    @Test
    public void scoreDoublesWhenPreviousFrameIsStrike() throws Exception {
        Frame frameWithPreviousFrameIsSpare = new NormalFrame(strikeFrame);
        frameWithPreviousFrameIsSpare.roll(2);
        assertThat(frameWithPreviousFrameIsSpare.score()).isEqualTo(4);
        frameWithPreviousFrameIsSpare.roll(4);
        assertThat(frameWithPreviousFrameIsSpare.score()).isEqualTo(12);
    }

   @Test
    public void isCompletedwhenTwoThrows() throws Exception {
        frame.roll(3);
        frame.roll(6);
        assertThat(frame.isCompleted()).isTrue();
    }

   @Test
    public void isNotCompletedwhenFirstThrowIsLowerThan10() throws Exception {
        frame.roll(3);
        assertThat(frame.isCompleted()).isFalse();
    }

}