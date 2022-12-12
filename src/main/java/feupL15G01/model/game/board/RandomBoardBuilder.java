package feupL15G01.model.game.board;


import feupL15G01.model.game.elements.*;

import java.util.*;

public class RandomBoardBuilder extends BoardBuilder {
    private final Random rng;

    private final int width;
    private final int height;
    private final int numberOfEnemies;

    private final int numberOfTempBlocks;

    private final int numberOfPowers;

    private List<Power> powersNew = new ArrayList<Power>();


    public RandomBoardBuilder(int width, int height, int numberOfEnemies, int numberOfTempBlocks, int numberOfPowers) {


        this.rng = new Random();

        this.width = width;
        this.height = height;
        this.numberOfEnemies = numberOfEnemies;
        this.numberOfTempBlocks = numberOfTempBlocks;
        this.numberOfPowers = numberOfPowers;
    }

    @Override
    public Board createBoard() {
        Board board = new Board(getWidth(), getHeight());

        board.setPlayer(createPlayer());
        board.setBomb(createBomb());
        board.setEnemies(createEnemies());
        board.setWalls(createWalls());
        board.setFixBlocks(createFixBlocks());
        board.setTempBlocks(createTempBlocks());
        board.setPowers(createPowers());
        board.setDoor(createDoor());

        return board;
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

            enemies.add(new Enemy(1 + rng.nextInt(width - 5) + 1, 2 + rng.nextInt(height - 6) + 1));

        return enemies;
    }

    @Override
    protected Player createPlayer() {
        return new Player(2, 2);
    }


    @Override
    protected Bomb createBomb() {
        return new Bomb(3,3);
    }
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
    protected List<TempBlock> createTempBlocks() {
        List<TempBlock> tempBlocks = new ArrayList<>();
        for( int i = 2; i<=width-4; i++){
            for( int j = 2; j<=height-4; j++){

               if(i%2 == 0 && (i>4 || j>4)){
                    tempBlocks.add(new TempBlock(i , j ));
               }
               if(i%2==1 && (j-1)*2 <= height-4 && (i>4 || (j-1)*2 > 4)){
                tempBlocks.add(new TempBlock(i, (j-1)*2));
               }

            }
        }

        while(tempBlocks.size()>numberOfTempBlocks){
            int rem = rng.nextInt(tempBlocks.size()-1);
            tempBlocks.remove(rem);
        }

        for(int a = 0; a<tempBlocks.size(); a++){
            Power toAdd = new Power(tempBlocks.get(a).getPosition().getX(),tempBlocks.get(a).getPosition().getY());
            powersNew.add(toAdd);
        }

        return tempBlocks;
    }
    @Override
    protected List<Power> createPowers() {
        List<Power> powers = powersNew;

        while(powers.size()>numberOfPowers){
            int rem = rng.nextInt(powers.size()-1);
            powers.remove(rem);
        }


        return powers;
    }

    @Override
    protected Door createDoor() {
        return null;
    }


}