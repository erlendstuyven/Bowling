package Game;

import javax.xml.validation.Validator;

public class Roll {


    private int pins = -1;

    Roll(){
        this.pins = pins;
    }

    void setPins(int pins) {
        if (pins > 10 || pins < -1) throw new IllegalArgumentException("Number of pins must be between 0 and 10");
        this.pins = pins;
    }

    int getPins() {
        return pins;
    }

    boolean isThrown(){
        return (pins > -1);
    }

    boolean hasTenPinsDown(){
        return (pins == 10);
    }
}
