package feupL15G01.viewer.menu;


import feupL15G01.gui.GUI;
import feupL15G01.model.Position;
import feupL15G01.model.game.board.RandomBoardBuilder;
import feupL15G01.model.menu.Menu;
import feupL15G01.viewer.Viewer;

public class MenuViewer extends Viewer<Menu> {
    public MenuViewer(Menu menu) {
        super(menu);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(3,5),"|((((((((((((((((((((((((|", "#FF2911");
        gui.drawText(new Position(4,6),"...                     ", "#DAA520");
        gui.drawText(new Position(4, 7),".  .                    ", "#DAA520");
        gui.drawText(new Position(4,8),".  . ... . . ..  ... ...", "#DAA520");
        gui.drawText(new Position(4,9),"...  . . ... . . .   . .", "#DAA520");
        gui.drawText(new Position(4,10),".  . . . . . ... ... ...", "#DAA520");
        gui.drawText(new Position(4,11),".  . . . . . . . .   .. ", "#DAA520");
        gui.drawText(new Position(4,12),"...  ... . . ..  ... . .", "#DAA520");
        gui.drawText(new Position(4,13),"                        ", "#DAA520");
        gui.drawText(new Position(4,14),"      . . ... .  .      ", "#DAA520");
        gui.drawText(new Position(4,15),"      ... . . .. .      ", "#DAA520");
        gui.drawText(new Position(4,16),"      . . ... . ..      ", "#DAA520");
        gui.drawText(new Position(4,17),"      . . . . .  .      ", "#DAA520");
        gui.drawText(new Position(4,18),"      . . . . .  .      ", "#DAA520");
        gui.drawText(new Position(3,19),"|________________________|", "#FF2911");

        gui.drawText(new Position(3,6),"|", "#FF2911");
        gui.drawText(new Position(3, 7),"|", "#FF2911");
        gui.drawText(new Position(3,8),"|", "#FF2911");
        gui.drawText(new Position(3,9),"|", "#FF2911");
        gui.drawText(new Position(3,10),"|", "#FF2911");
        gui.drawText(new Position(3,11),"|", "#FF2911");
        gui.drawText(new Position(3,12),"|", "#FF2911");
        gui.drawText(new Position(3,13),"|", "#FF2911");
        gui.drawText(new Position(3,14),"|", "#FF2911");
        gui.drawText(new Position(3,15),"|", "#FF2911");
        gui.drawText(new Position(3,16),"|", "#FF2911");
        gui.drawText(new Position(3,17),"|", "#FF2911");
        gui.drawText(new Position(3,18),"|", "#FF2911");

        gui.drawText(new Position(28,6),"|", "#FF2911");
        gui.drawText(new Position(28, 7),"|", "#FF2911");
        gui.drawText(new Position(28,8),"|", "#FF2911");
        gui.drawText(new Position(28,9),"|", "#FF2911");
        gui.drawText(new Position(28,10),"|", "#FF2911");
        gui.drawText(new Position(28,11),"|", "#FF2911");
        gui.drawText(new Position(28,12),"|", "#FF2911");
        gui.drawText(new Position(28,13),"|", "#FF2911");
        gui.drawText(new Position(28,14),"|", "#FF2911");
        gui.drawText(new Position(28,15),"|", "#FF2911");
        gui.drawText(new Position(28,16),"|", "#FF2911");
        gui.drawText(new Position(28,17),"|", "#FF2911");
        gui.drawText(new Position(28,18),"|", "#FF2911");

        gui.drawText(new Position(12, 22), "-------", "#FF2911");
        gui.drawText(new Position(12, 23), "|", "#FF2911");
        gui.drawText(new Position(12, 24), "-------", "#FF2911");
        gui.drawText(new Position(12, 25), "|", "#FF2911");
        gui.drawText(new Position(12, 26), "-------", "#FF2911");
        gui.drawText(new Position(18, 23), "|", "#FF2911");
        gui.drawText(new Position(18, 25), "|", "#FF2911");

        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(new Position(15-getModel().getEntry(i).length()/2, 23+(2*i)),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#5a4cae" : "#FFFFFF");

    }
}