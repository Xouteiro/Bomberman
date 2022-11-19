package feupL15G01.model.game.board;


import feupL15G01.model.Position;
import feupL15G01.model.game.elements.Player;
import feupL15G01.model.game.elements.Enemy;
import feupL15G01.model.game.elements.Wall;

import java.util.List;

public class Board {
    private final int width;
    private final int height;

    private Player player;

    private List<Enemy> enemies;
    private List<Wall> walls;

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public void setEnemies(List<Enemy> enemies) {
        this.enemies = enemies;
    }

    public List<Wall> getWalls() {
        return walls;
    }

    public void setWalls(List<Wall> walls) {
        this.walls = walls;
    }

    public boolean isEmpty(Position position) {
        for (Wall wall : walls)
            if (wall.getPosition().equals(position))
                return false;
        return true;
    }

    public boolean isEnemy(Position position) {
        for (Enemy enemy : enemies)
            if (enemy.getPosition().equals(position))
                return true;
        return false;
    }
}
