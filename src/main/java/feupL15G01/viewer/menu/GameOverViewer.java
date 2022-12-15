package feupL15G01.viewer.menu;

import feupL15G01.gui.GUI;
import feupL15G01.model.Position;
import feupL15G01.model.menu.GameOver;
import feupL15G01.viewer.Viewer;

public class GameOverViewer extends Viewer<GameOver> {
    public GameOverViewer(GameOver model) {
        super(model);
    }

    @Override
    protected void drawElements(GUI gui) {
        gui.drawText(new Position(11, 12), ",", "#f2e287");
        gui.drawText(new Position(12, 12), ";", "#707070");
        gui.drawText(new Position(13, 12), ",", "#f2e287");
        gui.drawText(new Position(14, 12), ";", "#707070");
        gui.drawText(new Position(15, 12), ",", "#f2e287");
        gui.drawText(new Position(16, 12), ";", "#707070");
        gui.drawText(new Position(17, 12), ",", "#f2e287");
        gui.drawText(new Position(18, 12), ";", "#707070");
        gui.drawText(new Position(19, 12), ",", "#f2e287");
        gui.drawText(new Position(20, 12), ";", "#707070");

        gui.drawText(new Position(10,12),";", "#707070" );




        gui.drawText(new Position(11, 14), "GAME OVER", "#FFFFFF");



        gui.drawText(new Position(9, 13), ",", "#f2e287");
        gui.drawText(new Position(9, 14), ";", "#707070");
        gui.drawText(new Position(9, 15), ",", "#f2e287");
        gui.drawText(new Position(10,16),";", "#707070" );

        gui.drawText(new Position(11, 16), ",", "#f2e287");
        gui.drawText(new Position(12, 16), ";", "#707070");
        gui.drawText(new Position(13, 16), ",", "#f2e287");
        gui.drawText(new Position(14, 16), ";", "#707070");
        gui.drawText(new Position(15, 16), ",", "#f2e287");
        gui.drawText(new Position(16, 16), ";", "#707070");
        gui.drawText(new Position(17, 16), ",", "#f2e287");
        gui.drawText(new Position(18, 16), ";", "#707070");
        gui.drawText(new Position(19, 16), ",", "#f2e287");
        gui.drawText(new Position(20, 16), ";", "#707070");

        gui.drawText(new Position(21, 13), ",", "#f2e287");
        gui.drawText(new Position(21, 14), ";", "#707070");
        gui.drawText(new Position(21, 15), ",", "#f2e287");


        gui.drawText(new Position(6, 18), "-------------------", "#FF2911");
        gui.drawText(new Position(6, 19), "|", "#FF2911");
        gui.drawText(new Position(6, 20), "-------------------", "#FF2911");
        gui.drawText(new Position(24, 19), "|", "#FF2911");
        gui.drawText(new Position(12, 22), "------", "#FF2911");
        gui.drawText(new Position(17, 21), "|", "#FF2911");
        gui.drawText(new Position(12, 21), "|", "#FF2911");

        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(new Position(15-getModel().getEntry(i).length()/2, 19+2*i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#5a4cae" : "#FFFFFF");
    }

    }

