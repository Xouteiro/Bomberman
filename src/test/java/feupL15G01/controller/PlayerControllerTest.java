package feupL15G01.controller;


import feupL15G01.model.Position;
import feupL15G01.model.game.board.Board;
import feupL15G01.model.game.elements.Player;
import feupL15G01.model.game.elements.Wall;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayerControllerTest {
    private PlayerController controller;
    private Player player;
    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board(10, 10);

        player = new Player(5, 5);
        board.setPlayer(player);

        board.setWalls(Arrays.asList());
        board.setEnemies(Arrays.asList());
        board.setFixBlocks(Arrays.asList());

        controller = new PlayerController(board);
    }

    @Test
    void movePlayerRightEmpty() {
        controller.movePlayerRight();
        assertEquals(new Position(6, 5), player.getPosition());
    }

    @Test
    void movePlayerRightNotEmpty() {
        board.setWalls(Arrays.asList(new Wall(6, 5)));
        controller.movePlayerRight();
        assertEquals(new Position(5, 5), player.getPosition());
    }
}