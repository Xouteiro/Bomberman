package feupL15G01.viewer.game;

import feupL15G01.gui.GUI;
import feupL15G01.model.Position;
import feupL15G01.model.game.elements.TempBlock;

public class TempBlockViewer implements ElementViewer<TempBlock> {
    @Override
    public void draw(TempBlock tempBlock, GUI gui) {
        gui.drawTempBlock(tempBlock.getPosition());
    }
}
