package Game;

import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * Created by bkerl on 28/10/15.
 */
public class GameTest {

    @Test
    public void roll() {
        Game game = new Game();
        game.roll(1);
        Assertions.assertThat(game.score()).isEqualTo(1);
        game.roll(3);
        Assertions.assertThat(game.score()).isEqualTo(4);
    }

    @Test
    public void rollWhenSpareThenTheNextThrowPinsAreAddedToPreviousFrame() {
        Game game = new Game();
        game.roll(4);
        Assertions.assertThat(game.score()).isEqualTo(4);
        game.roll(6);
        Assertions.assertThat(game.score()).isEqualTo(10);
        game.roll(2);
        Assertions.assertThat(game.score()).isEqualTo(14);
        game.roll(3);
        Assertions.assertThat(game.score()).isEqualTo(17);
    }

    @Test (expected = IllegalStateException.class)
    public void testThrowExceptionOneGameContainsMaximumTenFrames() {
        Game game = GameTestBuilder.create().rollNumberOfTimesOnePin(21).build();
    }


    @Test
    public void testOneGameContainsMaximumTenFrames() {
        Game game = GameTestBuilder.create().rollNumberOfTimesOnePin(20).build();
    }

}
