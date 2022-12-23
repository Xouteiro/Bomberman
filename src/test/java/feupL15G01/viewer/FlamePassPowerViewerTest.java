package feupL15G01.viewer;

import feupL15G01.gui.GUI;
import feupL15G01.model.game.elements.Power;
import feupL15G01.viewer.game.FlamePassPowerViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class FlamePassPowerViewerTest {
    private Power flamePower;
    private FlamePassPowerViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        flamePower = new Power(3, 3);
        viewer = new FlamePassPowerViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement() {
        viewer.draw(flamePower, gui);
        Mockito.verify(gui, Mockito.times(1)).drawFlamePassPower(flamePower.getPosition());
    }
}