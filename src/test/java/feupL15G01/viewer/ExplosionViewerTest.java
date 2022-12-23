package feupL15G01.viewer;

import feupL15G01.gui.GUI;
import feupL15G01.model.game.elements.Bomb;
import feupL15G01.model.game.elements.Explosion;
import feupL15G01.viewer.game.BombViewer;
import feupL15G01.viewer.game.ExplosionViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ExplosionViewerTest {
    private Explosion explosion;
    private ExplosionViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        explosion = new Explosion(3, 3);
        viewer = new ExplosionViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement() {
        viewer.draw(explosion, gui);
        Mockito.verify(gui, Mockito.times(1)).drawExplosion(explosion.getPosition());
    }
}