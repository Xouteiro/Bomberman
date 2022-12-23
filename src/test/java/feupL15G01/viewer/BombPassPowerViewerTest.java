package feupL15G01.viewer;

import feupL15G01.gui.GUI;
import feupL15G01.model.game.elements.Player;
import feupL15G01.viewer.game.PlayerViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class BombPassPowerViewerTest {
    private Player player;
    private PlayerViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        player = new Player(10, 10);
        viewer = new PlayerViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement() {
        viewer.draw(player, gui);
        Mockito.verify(gui, Mockito.times(1)).drawPlayer(player.getPosition());
    }
}