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

        for (int x = 1; x < width -2; x++) {
            walls.add(new Wall(x, 1));
            walls.add(new Wall(x, height - 3));
        }

        for (int y = 2; y < height - 3; y++) {
            walls.add(new Wall(1, y));
            walls.add(new Wall(width - 3, y));
        }

        return walls;
    }

    @Override

    protected List<Enemy> createEnemies() {
        List<Enemy> enemies = new ArrayList<>();

        while (enemies.size() < numberOfEnemies)
            enemies.add(new Enemy(rng.nextInt(width - 4) + 1, rng.nextInt(height - 4) + 1));

        return enemies;
    }

    @Override
    protected Player createPlayer() {
        return new Player(width / 2, height / 2);
    }

    //protected Bomb createBomb() {return new Bomb()}
    @Override
    protected List<FixBlock> createFixBlocks() {
        List<FixBlock> fixBlocks = new ArrayList<>();
        for(int i = 1; i*2<width-4; i++){
            for(int j = 1; j*2< height-4; j++){
                fixBlocks.add(new FixBlock(i*2+1,j*2+1));
            }
        }
        return fixBlocks;
    }

    @Override
    protected List<Power> createPowers() {
       List<Power> powers = new ArrayList<>();
        for(int i = 1; i*2<width-2; i++){
            for(int j = 1; j*2< height-2; j++){
                powers.add(new Power(i*2 ,j*2));
            }
        }


        return powers;
    }

    @Override
    protected List<TempBlock> createTempBlocks() {
        List<TempBlock> tempBlocks = new ArrayList<>();
        for(int i = 1; i*2<width-2; i++){
            for(int j = 1; j*2< height-2; j++){
                tempBlocks.add(new TempBlock(i*2,j*2));
            }
        }
        return tempBlocks;
    }


}