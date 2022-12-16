package feupL15G01.model.game.elements;
import java.awt.*;

public class Player extends Element {
    private int bombs;
    private int lives;
    private int points;

    private boolean bombPassAbility = false;

    private boolean tempBlockPassAbility = false;

    private boolean flamePassAbility = false;

    private boolean isOnTopOfTempBlock = false;
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

    public int getPoints() {
        return points;
    }

    public void incrementPoints(int points) {
        this.points += points;
    }

    public boolean hasBombPassAbility() {
        return bombPassAbility;
    }

    public void setBombPassAbility(boolean bombPassAbility) {
        this.bombPassAbility = bombPassAbility;
    }

    public boolean hasTempBlockPassAbility() {
        return tempBlockPassAbility;
    }

    public void setTempBlockPassAbility(boolean tempBlockPassAbility) {
        this.tempBlockPassAbility = tempBlockPassAbility;
    }

    public boolean hasFlamePassAbility() {
        return flamePassAbility;
    }

    public void setFlamePassAbility(boolean flamePassAbility) {
        this.flamePassAbility = flamePassAbility;
    }

    public boolean isOnTopOfTempBlock() {
        return isOnTopOfTempBlock;
    }

    public void setOnTopOfTempBlock(boolean onTopOfTempBlock) {
        isOnTopOfTempBlock = onTopOfTempBlock;
    }
}