package feupL15G01.viewer.game;


import feupL15G01.gui.GUI;
import feupL15G01.model.Position;
import feupL15G01.model.game.board.Board;
import feupL15G01.model.game.elements.Element;
import feupL15G01.viewer.Viewer;

import java.util.List;

public class GameViewer extends Viewer<Board> {
    public GameViewer(Board board) {
        super(board);
    }

    @Override
    public void drawElements(GUI gui) {

        drawElements(gui, getModel().getPowers(), new PowerViewer());
        drawElement(gui, getModel().getDoor(), new DoorViewer());


        drawElements(gui, getModel().getTempBlocks(), new TempBlockViewer());
        drawElements(gui, getModel().getWalls(), new WallViewer());
        drawElement(gui, getModel().getBomb(), new BombViewer());
        drawElements(gui, getModel().getEnemies(), new EnemyViewer());
        drawElements(gui, getModel().getFixBlocks() , new FixBlockViewer());

        drawElement(gui, getModel().getPlayer(), new PlayerViewer());



        gui.drawText(new Position(1, 1),  ".: "+ getModel().getPlayer().getBombs()  , "#B8B4B6");

        if(getModel().getPlayer().getLives() == 3) {
            gui.drawText(new Position(27, 1), "*", "#F40E00");
            gui.drawText(new Position(28, 1), "*", "#F40E00");
            gui.drawText(new Position(29, 1), "*", "#F40E00");
        }
        if(getModel().getPlayer().getLives() == 2) {
            gui.drawText(new Position(27, 1), "*", "#F40E00");
            gui.drawText(new Position(28, 1), "*", "#F40E00");
        }
        if(getModel().getPlayer().getLives() == 1) {
            gui.drawText(new Position(27, 1), "*" , "#F40E00");
        }

        gui.drawText(new Position(14, 1),"):" + getModel().getPlayer().getPoints() , "#DAA520");

        gui.drawText(new Position(20, 32), "Q to go back", "#FFFFFF");


    }

    private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)
            drawElement(gui, element, viewer);
    }

    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }


}