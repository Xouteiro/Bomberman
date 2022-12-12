package feupL15G01.model.game.elements;

public class Bomb extends Element{
    private int range = 1;
    public Bomb(int x, int y) {
        super(x, y);
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }
}
