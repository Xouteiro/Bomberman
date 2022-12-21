package feupL15G01.viewer;

import feupL15G01.gui.GUI;
import feupL15G01.model.Position;
import feupL15G01.model.game.board.Board;
import feupL15G01.model.game.elements.*;
import feupL15G01.viewer.game.GameViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;

class BoardViewerTest {
    private GUI gui;
    private GameViewer viewer;
    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board(10, 10);
        gui = Mockito.mock(GUI.class);
        viewer = new GameViewer(board);

        board.setWalls(Arrays.asList(new Wall(1, 2), new Wall(2, 3), new Wall(3, 4)));
        board.setEnemies(Arrays.asList(new Enemy(4, 5), new Enemy(5, 6)));
        board.setPlayer(new Player(5, 4));
        board.setFixBlocks(Arrays.asList(new FixBlock(5,8)));
        board.setTempBlocks(Arrays.asList(new TempBlock(6,9)));
        board.setPowers(Arrays.asList(new Power(3,6)));
        board.setBomb(new Bomb(1,3));
    }


    @Test
    void drawWalls() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawWall(new Position(1, 2));
        Mockito.verify(gui, Mockito.times(1)).drawWall(new Position(2, 3));
        Mockito.verify(gui, Mockito.times(1)).drawWall(new Position(3, 4));
        Mockito.verify(gui, Mockito.times(3)).drawWall(Mockito.any(Position.class));
    }

    @Test
    void drawEnemies() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawEnemy(new Position(4, 5));
        Mockito.verify(gui, Mockito.times(1)).drawEnemy(new Position(5, 6));
        Mockito.verify(gui, Mockito.times(2)).drawEnemy(Mockito.any(Position.class));
    }

    @Test
    void drawPlayer() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawPlayer(new Position(5, 4));
        Mockito.verify(gui, Mockito.times(1)).drawPlayer(Mockito.any(Position.class));
    }

    @Test
    void drawFixBlock() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawFixBlock(new Position(5, 8));
        Mockito.verify(gui, Mockito.times(1)).drawFixBlock(Mockito.any(Position.class));
    }

    @Test
    void drawTempBlock() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawTempBlock(new Position(6, 9));
        Mockito.verify(gui, Mockito.times(1)).drawTempBlock(Mockito.any(Position.class));
    }

    @Test
    void drawPower() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawLifePower(new Position(3, 6));
        Mockito.verify(gui, Mockito.times(1)).drawLifePower(Mockito.any(Position.class));
    }

    @Test
    void drawBomb() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawBomb(new Position(1, 3));
        Mockito.verify(gui, Mockito.times(1)).drawBomb(Mockito.any(Position.class));
    }

    @Test
    void refreshAndClear() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).clear();
        Mockito.verify(gui, Mockito.times(1)).refresh();
    }
}
