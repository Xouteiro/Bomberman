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
        getModel().getBomb().setPosition(getModel().getBomb().getPosition().goTo(getModel().getPlayer().getPosition().getX(),getModel().getPlayer().getPosition().getY()));
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                for(int i = 0; i< getModel().getTempBlocks().size(); i++){
                    if(getModel().isInRangeOf(getModel().getTempBlocks().get(i).getPosition(),getModel().getBomb().getPosition())){
                        getModel().getTempBlocks().get(i).setPosition(getModel().getTempBlocks().get(i).getPosition().goTo(1,1));
                    }
                }
                getModel().getBomb().setPosition(getModel().getBomb().getPosition().goTo(3,3));
                timer.cancel();
            }

        },1500);




    }
    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException{
        if (action == GUI.ACTION.BOMB) dropBomb();
    }
}
