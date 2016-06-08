package Game;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by bkerl on 01/06/16.
 */
public class LastFrame extends Frame {

    LastFrame(){}

    @Override
    int getMaximumNumberOfRolls() {
        return 3;
    }

    LastFrame(Frame previousFrame) {
        super(previousFrame);
    }

    @Override
    ArrayList<Roll> getRolls() {
        return new ArrayList<>(Arrays.asList(new Roll(), new Roll(), new Roll()));

    }
}
