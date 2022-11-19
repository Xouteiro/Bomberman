package feupL15G01.model.game.board;

import feupL15G01.model.game.elements.*;

import java.util.List;

public abstract class BoardBuilder {
    public Board createBoard() {
        Board board = new Board(getWidth(), getHeight());

        board.setPlayer(createPlayer());
        board.setEnemies(createEnemies());
        board.setWalls(createWalls());
        board.setFixBlocks(createFixBlocks());
        board.setTempBlocks(createTempBlocks());
        board.setPowers(createPowers());

        return board;
    }

    protected abstract int getWidth();

    protected abstract int getHeight();

    protected abstract List<Wall> createWalls();

    protected abstract List<Enemy> createEnemies();

    protected abstract Player createPlayer();

    protected abstract List<FixBlock> createFixBlocks();

    protected abstract List<TempBlock> createTempBlocks();

    protected abstract List<Power> createPowers();

}