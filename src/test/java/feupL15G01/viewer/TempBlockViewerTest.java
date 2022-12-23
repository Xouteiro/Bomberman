package feupL15G01.viewer;

import feupL15G01.gui.GUI;
import feupL15G01.model.game.elements.TempBlock;
import feupL15G01.viewer.game.TempBlockViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class TempBlockViewerTest {
    private TempBlock tempBlock;
    private TempBlockViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        tempBlock = new TempBlock(2,2);
        viewer = new TempBlockViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement() {
        viewer.draw(tempBlock, gui);
        Mockito.verify(gui, Mockito.times(1)).drawTempBlock(tempBlock.getPosition());
    }
}