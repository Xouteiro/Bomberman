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
        gui.drawText(new Position(11, 12), ")", "#DAA520");
        gui.drawText(new Position(12, 12), ".", "#959DA5");
        gui.drawText(new Position(13, 12), ")", "#DAA520");
        gui.drawText(new Position(14, 12), ".", "#959DA5");
        gui.drawText(new Position(15, 12), ")", "#DAA520");
        gui.drawText(new Position(16, 12), ".", "#959DA5");
        gui.drawText(new Position(17, 12), ")", "#DAA520");
        gui.drawText(new Position(18, 12), ".", "#959DA5");
        gui.drawText(new Position(19, 12), ")", "#DAA520");
        gui.drawText(new Position(20, 12), ".", "#959DA5");

        gui.drawText(new Position(10,13),".", "#959DA5" );
        gui.drawText(new Position(10, 14), ")", "#DAA520");
        gui.drawText(new Position(10,15),".", "#959DA5" );


        gui.drawText(new Position(12, 14), "You Win!", "#FFFFFF");



        gui.drawText(new Position(11, 16), ")", "#DAA520");
        gui.drawText(new Position(12, 16), ".", "#959DA5");
        gui.drawText(new Position(13, 16), ")", "#DAA520");
        gui.drawText(new Position(14, 16), ".", "#959DA5");
        gui.drawText(new Position(15, 16), ")", "#DAA520");
        gui.drawText(new Position(16, 16), ".", "#959DA5");
        gui.drawText(new Position(17, 16), ")", "#DAA520");
        gui.drawText(new Position(18, 16), ".", "#959DA5");
        gui.drawText(new Position(19, 16), ")", "#DAA520");
        gui.drawText(new Position(20, 16), ".", "#959DA5");

        gui.drawText(new Position(21, 13), ")", "#DAA520");
        gui.drawText(new Position(21, 14), ".", "#959DA5");
        gui.drawText(new Position(21, 15), ")", "#DAA520");



        gui.drawText(new Position(7, 18), "-------------------", "#FF2911");
        gui.drawText(new Position(7, 19), "|", "#FF2911");
        gui.drawText(new Position(7, 20), "-------------------", "#FF2911");
        gui.drawText(new Position(25, 19), "|", "#FF2911");
        gui.drawText(new Position(13, 22), "------", "#FF2911");
        gui.drawText(new Position(18, 21), "|", "#FF2911");
        gui.drawText(new Position(13, 21), "|", "#FF2911");

        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(new Position(16-getModel().getEntry(i).length()/2, 19+2*i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#DAA520" : "#FFFFFF");
    }
}
