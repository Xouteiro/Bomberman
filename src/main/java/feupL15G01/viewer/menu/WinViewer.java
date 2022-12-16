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
        gui.drawText(new Position(11, 5), ")", "#DAA520");
        gui.drawText(new Position(12, 5), ".", "#959DA5");
        gui.drawText(new Position(13, 5), ")", "#DAA520");
        gui.drawText(new Position(14, 5), ".", "#959DA5");
        gui.drawText(new Position(15, 5), ")", "#DAA520");
        gui.drawText(new Position(16, 5), ".", "#959DA5");
        gui.drawText(new Position(17, 5), ")", "#DAA520");
        gui.drawText(new Position(18, 5), ".", "#959DA5");
        gui.drawText(new Position(19, 5), ")", "#DAA520");
        gui.drawText(new Position(20, 5), ".", "#959DA5");

        gui.drawText(new Position(10,6),".", "#959DA5" );
        gui.drawText(new Position(10, 7), ")", "#DAA520");
        gui.drawText(new Position(10,8),".", "#959DA5" );


        gui.drawText(new Position(12, 7), "You Win!", "#FFFFFF");



        gui.drawText(new Position(11, 9), ")", "#DAA520");
        gui.drawText(new Position(12, 9), ".", "#959DA5");
        gui.drawText(new Position(13, 9), ")", "#DAA520");
        gui.drawText(new Position(14, 9), ".", "#959DA5");
        gui.drawText(new Position(15, 9), ")", "#DAA520");
        gui.drawText(new Position(16, 9), ".", "#959DA5");
        gui.drawText(new Position(17, 9), ")", "#DAA520");
        gui.drawText(new Position(18, 9), ".", "#959DA5");
        gui.drawText(new Position(19, 9), ")", "#DAA520");
        gui.drawText(new Position(20, 9), ".", "#959DA5");

        gui.drawText(new Position(21, 6), ")", "#DAA520");
        gui.drawText(new Position(21, 7), ".", "#959DA5");
        gui.drawText(new Position(21, 8), ")", "#DAA520");

        gui.drawText(new Position(12, 13), ")points)", "#DAA520");
        gui.drawText(new Position(15-String.valueOf(getModel().getPoints()).length()/2, 15), String.valueOf(getModel().getPoints()), "#DAA520");



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
                    getModel().isSelected(i) ? "#5a4cae" : "#FFFFFF");
    }
}
