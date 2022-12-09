package feupL15G01.viewer.game;

import feupL15G01.gui.GUI;
import feupL15G01.model.game.elements.Bomb;

public class BombViewer implements ElementViewer<Bomb>{
    @Override
    public void draw(Bomb bomb, GUI gui) {
        gui.drawBomb(bomb.getPosition());
    }
}
