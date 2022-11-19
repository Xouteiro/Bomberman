package feupL15G01.model.game.elements;


public class Enemy extends Element {

    private String type;
    private int iq; //inteligência

    public Enemy(int x, int y) {
        super(x, y);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }
}