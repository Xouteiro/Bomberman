package feupL15G01.viewer.game;

import feupL15G01.gui.GUI;
import feupL15G01.model.game.elements.FixBlock;

public class FixBlockViewer implements ElementViewer<FixBlock>{
    public void draw(FixBlock fixBlock, GUI gui) {
        gui.drawFixedBlock(fixBlock.getPosition());
    }
}
