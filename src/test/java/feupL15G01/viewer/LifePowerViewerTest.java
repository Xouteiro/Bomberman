package feupL15G01.viewer;

import feupL15G01.gui.GUI;
import feupL15G01.model.game.elements.Power;
import feupL15G01.viewer.game.LifePowerViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class LifePowerViewerTest {
    private Power lifePower;
    private LifePowerViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        lifePower = new Power(2, 2);
        viewer = new LifePowerViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement() {
        viewer.draw(lifePower, gui);
        Mockito.verify(gui, Mockito.times(1)).drawLifePower(lifePower.getPosition());
    }
}