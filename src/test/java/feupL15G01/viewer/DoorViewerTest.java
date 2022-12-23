package feupL15G01.viewer;

import feupL15G01.gui.GUI;
import feupL15G01.model.game.elements.Door;
import feupL15G01.viewer.game.DoorViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class DoorViewerTest {
    private Door door;
    private DoorViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        door = new Door(6, 6);
        viewer = new DoorViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement() {
        viewer.draw(door, gui);
        Mockito.verify(gui, Mockito.times(1)).drawDoor(door.getPosition());
    }
}