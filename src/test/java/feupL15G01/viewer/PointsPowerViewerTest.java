package feupL15G01.viewer;

import feupL15G01.gui.GUI;
import feupL15G01.model.game.elements.Power;
import feupL15G01.viewer.game.PointsPowerViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PointsPowerViewerTest {
    private Power pointsPower;
    private PointsPowerViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        pointsPower = new Power(8, 9);
        viewer = new PointsPowerViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement() {
        viewer.draw(pointsPower, gui);
        Mockito.verify(gui, Mockito.times(1)).drawPointsPower(pointsPower.getPosition());
    }
}