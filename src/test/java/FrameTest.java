import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

public class FrameTest {

    private Frame frame = new Frame(new Frame());

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