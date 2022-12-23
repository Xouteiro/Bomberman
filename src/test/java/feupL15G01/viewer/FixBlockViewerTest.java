package feupL15G01.viewer;

import feupL15G01.gui.GUI;
import feupL15G01.model.game.elements.FixBlock;
import feupL15G01.viewer.game.FixBlockViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class FixBlockViewerTest {
    private FixBlock fixBlock;
    private FixBlockViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        fixBlock = new FixBlock(7, 7);
        viewer = new FixBlockViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement() {
        viewer.draw(fixBlock, gui);
        Mockito.verify(gui, Mockito.times(1)).drawFixBlock(fixBlock.getPosition());
    }
}