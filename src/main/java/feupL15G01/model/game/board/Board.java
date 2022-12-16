package feupL15G01.model.game.board;


import feupL15G01.model.Position;
import feupL15G01.model.game.elements.*;

import java.util.List;

public class Board {
    private final int width;
    private final int height;

    private Player player;
    private Bomb bomb;

    private List<Explosion> explosions;
    private List<Enemy> enemies;
    private List<Wall> walls;
    private List<FixBlock> fixBlocks;
    private List<TempBlock> tempBlocks;
    private List<Power> powers;

    private Door door;

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

    public Bomb getBomb() {
        return bomb;
    }

    public void setBomb(Bomb bomb) {
        this.bomb = bomb;
    }

    public List<Explosion> getExplosions() {
        return explosions;
    }

    public void setExplosions(List<Explosion> explosions) {
        this.explosions = explosions;
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

    public Door getDoor() {
        return door;
    }

    public void setDoor(Door door) {
        this.door = door;
    }
    public boolean isEmpty(Position position) {
        for (Wall wall : walls)
            if (wall.getPosition().equals(position))
                return false;
        for (FixBlock fixBlock : fixBlocks) {
            if (fixBlock.getPosition().equals(position))
                return false;
        }
        if(!getPlayer().hasTempBlockPassAbility()) {
            for (TempBlock tempBlock : tempBlocks) {
                if (tempBlock.getPosition().equals(position)) {
                    return false;
                }
            }
        }
        if(!getPlayer().hasBombPassAbility()) {
            return !bomb.getPosition().equals(position);
        }
            return true;

    }

    public boolean isEnemy(Position position) {
        for (Enemy enemy : enemies)
            if (enemy.getPosition().equals(position))
                return true;
        return false;
    }

    public boolean isLifePower(Position position) {
        for (Power power : powers)
            if (power.getPosition().equals(position) && power.getType() == 1)
                return true;
        return false;
    }

    public boolean isPointsPower(Position position) {
        for (Power power : powers)
            if (power.getPosition().equals(position) && power.getType() == 2)
                return true;
        return false;
    }

    public boolean isBombPassPower(Position position) {
        for (Power power : powers)
            if (power.getPosition().equals(position) && power.getType() == 3)
                return true;
        return false;
    }

    public boolean isTempBlockPassPower(Position position) {
        for (Power power : powers)
            if (power.getPosition().equals(position) && power.getType() == 4)
                return true;
        return false;
    }

    public boolean isFlamePassPower(Position position) {
        for (Power power : powers)
            if (power.getPosition().equals(position) && power.getType() == 5)
                return true;
        return false;
    }


    public boolean isInRangeOf(Position elementPosition, Position bombPosition) {
        if ((elementPosition.getY() == bombPosition.getY() && bombPosition.getX() + bomb.getRange() == elementPosition.getX()) || (elementPosition.getX() == bombPosition.getX() - bomb.getRange() && elementPosition.getY() == bombPosition.getY()) ) {
            return true;
        }
        if ((elementPosition.getX() == bombPosition.getX() && bombPosition.getY() + bomb.getRange() == elementPosition.getY()) || (elementPosition.getY() == bombPosition.getY() - bomb.getRange() && elementPosition.getX() == bombPosition.getX()) ) {
            return true;
        }
        if(elementPosition.getX()==bombPosition.getX() && elementPosition.getY()==bombPosition.getY()){
            return true;
        }

        return false;
    }



}
