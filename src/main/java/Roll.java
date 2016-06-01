
public class Roll {


    private int pins = -1;

    Roll(){
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
