package feupL15G01.model.game.board;

import feupL15G01.model.game.elements.Enemy;
import feupL15G01.model.game.elements.Player;
import feupL15G01.model.game.elements.Wall;

import java.util.List;

public abstract class BoardBuilder {
    public Board createBoard() {
        Board board = new Board(getWidth(), getHeight());

        board.setPlayer(createPlayer());
        board.setEnemies(createEnemies());
        board.setWalls(createWalls());

        return board;
    }

    protected abstract int getWidth();

    protected abstract int getHeight();

    protected abstract List<Wall> createWalls();

    protected abstract List<Enemy> createEnemies();

    protected abstract Player createPlayer();
}