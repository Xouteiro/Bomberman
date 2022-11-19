package feupL15G01.model.game.board;


import feupL15G01.model.game.elements.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomBoardBuilder extends BoardBuilder {
    private final Random rng;

    private final int width;
    private final int height;
    private final int numberOfEnemies;

    public RandomBoardBuilder(int width, int height, int numberOfEnemies) {
        this.rng = new Random();

        this.width = width;
        this.height = height;
        this.numberOfEnemies = numberOfEnemies;
    }

    @Override
    protected int getWidth() {
        return width;
    }

    @Override
    protected int getHeight() {
        return height;
    }

    @Override
    protected List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();

        for (int x = 0; x < width; x++) {
            walls.add(new Wall(x, 0));
            walls.add(new Wall(x, height - 1));
        }

        for (int y = 1; y < height - 1; y++) {
            walls.add(new Wall(0, y));
            walls.add(new Wall(width - 1, y));
        }

        return walls;
    }

    @Override
    protected List<Enemy> createEnemies() {
        List<Enemy> enemies = new ArrayList<>();

        while (enemies.size() < numberOfEnemies)
            enemies.add(new Enemy(rng.nextInt(width - 2) + 1, rng.nextInt(height - 2) + 1));

        return enemies;
    }

    @Override
    protected Player createPlayer() {
        return new Player(width / 2, height / 2);
    }

    @Override
    protected List<FixBlock> createFixBlocks() {

        //fazer com que os blocos apareçam como no jogo;

        return null;
    }

    @Override
    protected List<TempBlock> createTempBlocks() {

        //fazer com que os blocos apareçam aleatoriamente onde naexistirem fixBlocks

        return null;
    }

    @Override
    protected List<Power> createPowers() {

        //fazer com que os poderes apareaçam aleatoriamente por baixo de alguns TempBlocks

        return null;
    }
}