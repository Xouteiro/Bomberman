package feupL15G01.model.game.elements;

public class Door extends TempBlock {

    private boolean available;

    public Door(int x, int y) {
        super(x, y);
        this.available = false;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable() {
        this.available = true;
    }
    public void setNotAvailable(){
        this.available = false;
    }
}