package feupL15G01.viewer;

import feupL15G01.gui.GUI;
import feupL15G01.model.game.elements.Wall;
import feupL15G01.viewer.game.WallViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class WallViewerTest {
    private Wall wall;
    private WallViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        wall = new Wall(1, 0);
        viewer = new WallViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement() {
        viewer.draw(wall, gui);
        Mockito.verify(gui, Mockito.times(1)).drawWall(wall.getPosition());
    }
}