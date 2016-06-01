package Game;

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
            int counter = 0;
            while (counter < numberOfRolls){
                game.roll(1);
                counter++;
            }
        }
        return game;
    }

    GameTestBuilder rollNumberOfTimesOnePin(int numberOfRolls){
        this.numberOfRolls = numberOfRolls;
        return this;
    }
}
