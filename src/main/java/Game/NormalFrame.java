package Game;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by bkerl on 01/06/16.
 */
public class NormalFrame extends Frame {

    NormalFrame(){}

    @Override
    int getMaximumNumberOfRolls() {
        return 2;
    }

    NormalFrame(Frame previousFrame) {
        super(previousFrame);
    }

    @Override
    ArrayList<Roll> getRolls() {
        return new ArrayList<>(Arrays.asList(new Roll(), new Roll()));

    }
}
