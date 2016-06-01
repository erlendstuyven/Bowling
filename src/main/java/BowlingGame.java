import Game.Game;

public class BowlingGame {

    private Game game = new Game();

    public void roll(int pins) {
        game.roll(pins);
    }

    public int score() {
        return game.score();
    }

}
