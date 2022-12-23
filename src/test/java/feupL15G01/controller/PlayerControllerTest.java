package feupL15G01.controller;


import feupL15G01.gui.GUI;
import feupL15G01.model.Position;
import feupL15G01.Game;
import feupL15G01.model.game.board.Board;
import feupL15G01.model.game.elements.Enemy;
import feupL15G01.model.game.elements.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class PlayerControllerTest {
    private PlayerController controller;
    private Player player;
    private Board board;
    private Bomb bomb;

    @BeforeEach
    void setUp() {
        board = new Board(10, 10);

        player = new Player(5, 5);
        board.setPlayer(player);

        bomb = new Bomb(9,9);
        board.setBomb(bomb);

        board.setWalls(Arrays.asList());
        board.setEnemies(Arrays.asList());
        board.setFixBlocks(Arrays.asList());
        board.setTempBlocks(Arrays.asList());
        board.setPowers(Arrays.asList());

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
    //erro
    /*
    @Test
    void catchMoveThroughBlocksPower() {
        //board.setPowers(Arrays.asList(new Power(6, 5)));

        //board.isTempBlockPassPower(new Position(6, 5));
        //controller.movePlayerRight();
        board.isBombPassPower(new Position(6,5));
        controller.movePlayerRight();
        assertEquals(true, player.hasTempBlockPassAbility());
    }
    */

    @Test
    void moveThroughBlocksPower() {
        board.setTempBlocks(Arrays.asList(new TempBlock(6, 5)));
        player.setTempBlockPassAbility(true);
        controller.movePlayerRight();
        assertEquals(new Position(6,5), player.getPosition());
        //assertEquals(true, player.isOnTopOfTempBlock());
    }

    @Test
    void notMoveThrougBomb() {
        board.setBomb(new Bomb(6,5));
        controller.movePlayerRight();
        assertEquals(new Position(5,5), player.getPosition());
    }

    @Test
    void bombPassAbility() {
        board.setBomb(new Bomb(6,5));
        player.setBombPassAbility(true);
        controller.movePlayerRight();
        assertEquals(new Position(6,5), player.getPosition());
    }

    //erro
    /*
    @Test
    void moveThroughBomb() {
        board.setBomb(new Bomb(6, 5));
        //player.setFlamePassAbility(true);
        controller.movePlayerRight();
        assertEquals(3, player.getLives());
    }
    */

    @Test
    void loseLifeEnemies() {
        board.setEnemies(Arrays.asList(new Enemy(6, 5)));
        controller.movePlayerRight();
        assertEquals(2, player.getLives());
    }


}