package feupL15G01.model.game;

public class Power extends TempBlock{

    private String type;

    public Power(int x, int y) {
        super(x, y);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
