package feupL15G01.controller;

import feupL15G01.Game;
import feupL15G01.gui.GUI;
import feupL15G01.model.game.board.Board;
import feupL15G01.model.game.elements.Bomb;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class BombController extends GameController{

    public BombController(Board board) {
        super(board);
    }


    private void dropBomb(){
            getModel().getBomb().setPosition(getModel().getBomb().getPosition().goTo(getModel().getPlayer().getPosition().getX(), getModel().getPlayer().getPosition().getY()));
            getModel().getPlayer().removeBomb();
            final Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    for (int i = 0; i < getModel().getTempBlocks().size(); i++) {
                        if (getModel().isInRangeOf(getModel().getTempBlocks().get(i).getPosition(), getModel().getBomb().getPosition())) {
                            getModel().getTempBlocks().remove(i);
                        }
                    }
                    for (int i = 0; i < getModel().getEnemies().size(); i++) {
                        if (getModel().isInRangeOf(getModel().getEnemies().get(i).getPosition(), getModel().getBomb().getPosition())) {
                            getModel().getEnemies().remove(i);
                        }
                    }
                    if(getModel().isInRangeOf(getModel().getPlayer().getPosition(),getModel().getBomb().getPosition())){
                        getModel().getPlayer().removeLive();
                    }
                    getModel().getBomb().setPosition(getModel().getBomb().getPosition().goTo(3, 3));
                    getModel().getPlayer().addBomb();
                    if(getModel().getEnemies().isEmpty()){
                        getModel().getDoor().setAvailable();
                    }
                    timer.cancel();
                }

            }, 1500);

    }
    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException{
        if (action == GUI.ACTION.BOMB && getModel().getPlayer().getBombs()>0) dropBomb();
    }
}
