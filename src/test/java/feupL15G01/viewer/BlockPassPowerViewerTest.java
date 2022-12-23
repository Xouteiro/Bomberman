package feupL15G01.viewer;

import feupL15G01.gui.GUI;
import feupL15G01.model.game.elements.Power;
import feupL15G01.viewer.game.TempBlockPassPowerViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class BlockPassPowerViewerTest {
    private Power passPower;
    private TempBlockPassPowerViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        passPower = new Power(6, 5);
        viewer = new TempBlockPassPowerViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement() {
        viewer.draw(passPower, gui);
        Mockito.verify(gui, Mockito.times(1)).drawTempBlockPassPower(passPower.getPosition());
    }
}