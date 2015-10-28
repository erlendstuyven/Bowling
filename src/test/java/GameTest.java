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
    }
}