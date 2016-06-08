package Game;

import java.util.stream.IntStream;

/**
 * Created by bkerl on 01/06/16.
 */
public class GameTestBuilder {

    private int numberOfRolls;

    static GameTestBuilder create() {
        return new GameTestBuilder();
    }

    Game build(){
        Game game = new Game();
        if (numberOfRolls > 0) {
            IntStream.range(0,numberOfRolls).forEach(g -> game.roll(1));
        }
        return game;
    }

    GameTestBuilder rollNumberOfTimesOnePin(int numberOfRolls){
        this.numberOfRolls = numberOfRolls;
        return this;
    }
}
