import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by bkerl on 28/10/15.
 */
public class Game {

    private LinkedList<Frame> frames = new LinkedList<Frame>();

    void roll(int pins) {
        Frame frame = new Frame();
        frames.add(frame);
        frame.roll(pins);
    }

    int score() {
        Frame frame = frames.iterator().next();
        return frame.score();
    }

}
