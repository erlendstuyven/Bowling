
public class Throw {


    private int pins = -1;

    Throw(){
        this.pins = pins;
    }

    void setPins(int pins) {
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
