package feupL15G01.model.game.elements;
import java.awt.*;

public class Player extends Element {
    private int bombs;
    private int lives;

    private int points;

    private int passThroughDoor = 0;

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

    public void addLive(){
        this.lives ++;
    }

    public void removeLive(){
        this.lives --;
    }

    public int getLives() {
        return lives;
    }

    public int getPassThroughDoor() {
        return passThroughDoor;
    }

    public void setPassThroughDoor(int i) {
        this.passThroughDoor = i;
    }


    public int getPoints() {
        return points;
    }

    public void incrementPoints(int points) {
        this.points += points;
    }
}