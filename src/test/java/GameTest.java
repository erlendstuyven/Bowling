import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.junit.Assert.*;

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
    public void rollWhenSpareThenTheNextThrownPinsAreAddedToPreviousFrame() {
        Game game = new Game();
        game.roll(4);
        Assertions.assertThat(game.score()).isEqualTo(4);
        game.roll(6);
        Assertions.assertThat(game.score()).isEqualTo(10);
        game.roll(2);
        Assertions.assertThat(game.score()).isEqualTo(14);
    }
}