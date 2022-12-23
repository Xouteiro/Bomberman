package feupL15G01.controller;

import feupL15G01.Game;
import feupL15G01.gui.GUI;
import feupL15G01.model.Position;
import feupL15G01.model.game.board.Board;
import feupL15G01.model.game.elements.Bomb;
import feupL15G01.model.game.elements.Explosion;

import java.io.IOException;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class BombController extends GameController{

    public BombController(Board board) {
        super(board);
    }


    private void dropBomb(){
        Position bombLastPosition = new Position(getModel().getPlayer().getPosition().getX(), getModel().getPlayer().getPosition().getY());
        Position bombNewPosition = getModel().getBomb().getPosition().goTo(getModel().getPlayer().getPosition().getX(), getModel().getPlayer().getPosition().getY());
        
        getModel().getBomb().setPosition(bombNewPosition);
        getModel().getPlayer().removeBomb();

        CompletableFuture.delayedExecutor(1500, TimeUnit.MILLISECONDS).execute(() -> {

            for (int i = 0; i < getModel().getTempBlocks().size(); i++) {
                if (getModel().isInRangeOf(getModel().getTempBlocks().get(i).getPosition(), getModel().getBomb().getPosition())) {
                    getModel().getTempBlocks().remove(i);
                    i--;
                    getModel().getPlayer().incrementPoints(10);
                }
            }
            for (int i = 0; i < getModel().getEnemies().size(); i++) {
                if (getModel().isInRangeOf(getModel().getEnemies().get(i).getPosition(), getModel().getBomb().getPosition())) {
                    getModel().getEnemies().remove(i);
                    getModel().getPlayer().incrementPoints(100);
                }
            }
            if(getModel().isInRangeOf(getModel().getPlayer().getPosition(),getModel().getBomb().getPosition()) && !getModel().getPlayer().hasFlamePassAbility()){
                getModel().getPlayer().removeLife();
                getModel().getPlayer().setBombPassAbility(false);
                getModel().getPlayer().setTempBlockPassAbility(false);
            }

            getModel().getBomb().setPosition(getModel().getBomb().getPosition().goTo(3, 3));
            getModel().getPlayer().addBomb();

            List<Explosion> explosions = getModel().getExplosions();

            explosions.get(0).setPosition(bombLastPosition.getUp());
            explosions.get(1).setPosition(bombLastPosition.getLeft());
            explosions.get(2).setPosition(bombLastPosition);
            explosions.get(3).setPosition(bombLastPosition.getDown());
            explosions.get(4).setPosition(bombLastPosition.getRight());

            if(getModel().getEnemies().isEmpty()){
                getModel().getDoor().setAvailable();
            }

            CompletableFuture.delayedExecutor(300, TimeUnit.MILLISECONDS).execute(() -> {
                explosions.get(0).setPosition(new Position(3,3));
                explosions.get(1).setPosition(new Position(3,3));
                explosions.get(2).setPosition(new Position(3,3));
                explosions.get(3).setPosition(new Position(3,3));
                explosions.get(4).setPosition(new Position(3,3));
            });
        });



    }
    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException{
        if (action == GUI.ACTION.BOMB && getModel().getPlayer().getBombs()>0){
            dropBomb();
        }
    }

}

