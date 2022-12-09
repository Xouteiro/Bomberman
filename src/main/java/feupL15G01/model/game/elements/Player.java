package feupL15G01.model.game.elements;
import java.awt.*;

public class Player extends Element {
    private int bombs;

    public Player(int x, int y) {
        super(x, y);
        this.bombs = 1;
    }

    public void addBombs() {
        this.bombs++;
    }

    public int getBombs() {
        return bombs;
    }
}