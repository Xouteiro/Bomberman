package feupL15G01.model.game.board;


import feupL15G01.model.Position;
import feupL15G01.model.game.elements.*;

import java.util.List;

public class Board {
    private final int width;
    private final int height;

    private Player player;
    private List<Enemy> enemies;
    private List<Wall> walls;
    private List<FixBlock> fixBlocks;
    private List<TempBlock> tempBlocks;
    private List<Power> powers;

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


    public List<FixBlock> getFixBlocks() {
        return fixBlocks;
    }

    public void setFixBlocks(List<FixBlock> fixBlocks) {
        this.fixBlocks = fixBlocks;
    }


    public List<TempBlock> getTempBlocks() {
        return tempBlocks;
    }

    public void setTempBlocks(List<TempBlock> tempBlocks) {
        this.tempBlocks = tempBlocks;
    }

    public List<Power> getPowers() {
        return powers;
    }

    public void setPowers(List<Power> powers) {
        this.powers = powers;
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
