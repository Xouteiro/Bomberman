package feupL15G01.viewer.game;

import feupL15G01.gui.GUI;
import feupL15G01.model.game.elements.Element;
import feupL15G01.model.game.elements.Explosion;

public class ExplosionViewer implements ElementViewer<Explosion>{
    @Override
    public void draw(Explosion explosion, GUI gui) {
        gui.drawExplosion(explosion.getPosition());
    }
}
