package feupL15G01.viewer.game;

import feupL15G01.gui.GUI;
import feupL15G01.model.game.elements.Player;

public class PlayerOnTempBlocksViewer implements ElementViewer<Player> {

    @Override
    public void draw(Player bomberman, GUI gui) {
            gui.drawPlayerOnTempBlocksViewer(bomberman.getPosition());
    }

}
