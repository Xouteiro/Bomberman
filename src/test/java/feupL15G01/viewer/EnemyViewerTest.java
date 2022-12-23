package feupL15G01.viewer;

import feupL15G01.gui.GUI;
import feupL15G01.model.game.elements.Enemy;
import feupL15G01.viewer.game.EnemyViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class EnemyViewerTest {
    private Enemy enemy;
    private EnemyViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        enemy = new Enemy(8, 8);
        viewer = new EnemyViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement() {
        viewer.draw(enemy, gui);
        Mockito.verify(gui, Mockito.times(1)).drawEnemy(enemy.getPosition());
    }
}