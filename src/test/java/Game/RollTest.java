package Game;

import org.junit.Test;

import static org.junit.Assert.*;

public class RollTest {

    @Test(expected = IllegalArgumentException.class)
    public void testMoreThanTenPinsInOneRollIsNotPossible(){
        Roll roll = new Roll();
        roll.setPins(11);
    }
}