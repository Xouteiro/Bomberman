package feupL15G01.viewer;

import feupL15G01.gui.GUI;
import feupL15G01.model.game.elements.Power;
import feupL15G01.viewer.game.BombPassPowerViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class BombPassPowerViewerTest {
    private Power bombPower;
    private BombPassPowerViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        bombPower = new Power(10, 10);
        viewer = new BombPassPowerViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement() {
        viewer.draw(bombPower, gui);
        Mockito.verify(gui, Mockito.times(1)).drawBombPassPower(bombPower.getPosition());
    }
}