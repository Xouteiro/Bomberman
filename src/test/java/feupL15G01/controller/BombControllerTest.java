package feupL15G01.controller;


import feupL15G01.model.Position;
import feupL15G01.model.game.board.Board;
import feupL15G01.model.game.elements.Bomb;
import feupL15G01.model.game.elements.Player;
import feupL15G01.model.game.elements.Wall;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class BombControllerTest {

    private PlayerController playercontroller;
    private BombController controller;

    private Board board;

    private Bomb bomb;

    private Player player;


    @BeforeEach
    void setUp() {
        board = new Board(10, 10);

        controller = new BombController(board);
        playercontroller = new PlayerController(board);

        player = new Player(4,4);
        board.setPlayer(player);

        bomb = new Bomb(6,6);
        board.setBomb(bomb);

        board.setWalls(Arrays.asList());
        board.setEnemies(Arrays.asList());
        board.setFixBlocks(Arrays.asList());
        board.setTempBlocks(Arrays.asList());
        board.setPowers(Arrays.asList());

    }

    @Test
    void playerBombPlaced() {
        playercontroller.movePlayerRight();
        controller.dropBomb();
        assertEquals(new Position(5, 4), bomb.getPosition());
    }
}