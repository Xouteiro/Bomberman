package feupL15G01.controller;
import feupL15G01.Game;
import feupL15G01.gui.GUI;
import feupL15G01.model.Position;
import feupL15G01.model.game.board.Board;
import feupL15G01.Game;
import feupL15G01.model.game.elements.Bomb;
import feupL15G01.model.game.elements.Enemy;
import feupL15G01.model.game.elements.Player;
import feupL15G01.model.game.elements.Wall;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class EnemyControllerTest {
    private EnemyController controller;
    private Player player;
    private Board board;
    private Game game;
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

        controller = new EnemyController(board);

        game = Mockito.mock(Game.class);
    }

    @Test
    void moveEnemy() throws IOException {
        Enemy enemy = new Enemy(5, 5);
        board.setEnemies(Arrays.asList(enemy));

        controller.step(game, GUI.ACTION.NONE, 1000);
        assertNotEquals(new Position(5, 5), enemy.getPosition());
    }

    @Test
    void moveEnemiesClosed() throws IOException {
        Enemy enemy = new Enemy(5, 5);
        board.setEnemies(Arrays.asList(enemy));
        board.setWalls(Arrays.asList(
                new Wall(4, 5),
                new Wall(6, 5),
                new Wall(5, 4),
                new Wall(5, 6)
        ));

        for (int i = 0; i < 10; i++)
            controller.step(game, GUI.ACTION.NONE, 1000);

        assertEquals(new Position(5, 5), enemy.getPosition());
    }

    @Test
    void moveEnemyGap() throws IOException {
        Enemy enemy = new Enemy(5, 5);
        board.setEnemies(Arrays.asList(enemy));
        board.setWalls(Arrays.asList(
                new Wall(4, 5),
                new Wall(6, 5),
                new Wall(5, 4)
        ));

        long time = 0;

        while (enemy.getPosition().equals(new Position(5, 5))) {
            time += 500;
            controller.step(game, GUI.ACTION.NONE, time);
        }

        assertEquals(new Position(5, 6), enemy.getPosition());
    }
    /*
    @Test
    void dieEnemy() throws IOException{
        Enemy enemy = new Enemy(8,9);
        board.setEnemies(Arrays.asList(enemy));

        long time = 0;

        if (board.isInRangeOf(enemy.getPosition(),new Position(9, 9))){
            assertEquals(get);

        }
    }
    */
}