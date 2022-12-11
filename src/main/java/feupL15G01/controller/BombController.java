package feupL15G01.controller;

import feupL15G01.Game;
import feupL15G01.gui.GUI;
import feupL15G01.model.game.board.Board;
import feupL15G01.model.game.elements.Bomb;

import java.io.IOException;

public class BombController extends GameController{

    public BombController(Board board) {
        super(board);
    }


    private void dropBomb(){
        getModel().getBomb().setPosition(getModel().getBomb().getPosition().goTo(getModel().getPlayer().getPosition().getX(),getModel().getPlayer().getPosition().getY()));
    }
    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.BOMB) dropBomb();
    }
}
