package feupL15G01.viewer.menu;

import feupL15G01.gui.GUI;
import feupL15G01.model.Position;
import feupL15G01.model.menu.Win;
import feupL15G01.viewer.Viewer;

public class WinViewer extends Viewer<Win> {
    public WinViewer(Win model) {
        super(model);
    }

    @Override
    protected void drawElements(GUI gui) {
        gui.drawText(new Position(12, 14), "You Win!.", "#FFFFFF");
        gui.drawText(new Position(11, 14), ".", "#DAA520");
        gui.drawText(new Position(20, 14), ".", "#DAA520");

        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(new Position(16-getModel().getEntry(i).length()/2, 19+2*i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#DAA520" : "#FFFFFF");
    }
}
