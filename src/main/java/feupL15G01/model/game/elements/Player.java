package feupL15G01.model.game.elements;
import java.awt.*;

public class Player extends Element {
    private int bombs;
    private int lives;

    public Player(int x, int y) {
        super(x, y);
        this.bombs = 1;
        this.lives = 3;
    }

    public void addBomb() {
        this.bombs++;
    }
    public void removeBomb(){
        this.bombs--;
    }

    public int getBombs() {
        return bombs;
    }

    public void addLife(){
        this.lives ++;
    }

    public void removeLife(){
        this.lives --;
    }

    public int getLives() {
        return lives;
    }
}