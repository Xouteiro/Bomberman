package feupL15G01.viewer;

import feupL15G01.gui.GUI;
import feupL15G01.model.game.elements.Bomb;
import feupL15G01.model.game.elements.Player;
import feupL15G01.viewer.game.BombViewer;
import feupL15G01.viewer.game.PlayerViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class BombViewerTest {
    private Bomb bomb;
    private BombViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        bomb = new Bomb(5, 5);
        viewer = new BombViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement() {
        viewer.draw(bomb, gui);
        Mockito.verify(gui, Mockito.times(1)).drawBomb(bomb.getPosition());
    }
}