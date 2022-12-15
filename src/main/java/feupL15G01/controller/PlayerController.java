package feupL15G01.controller;

import feupL15G01.Game;
import feupL15G01.gui.GUI;
import feupL15G01.model.Position;
import feupL15G01.model.game.board.Board;
import feupL15G01.model.game.elements.Bomb;
import feupL15G01.model.menu.Win;
import feupL15G01.states.WinState;

import java.util.Random;

public class
PlayerController extends GameController {


    public PlayerController(Board board) {
        super(board);
    }

    public void movePlayerLeft() {
        movePlayer(getModel().getPlayer().getPosition().getLeft());
    }

    public void movePlayerRight() {
        movePlayer(getModel().getPlayer().getPosition().getRight());
    }

    public void movePlayerUp() {
        movePlayer(getModel().getPlayer().getPosition().getUp());
    }

    public void movePlayerDown() {
        movePlayer(getModel().getPlayer().getPosition().getDown());
    }

    private void movePlayer(Position position) {

        if (getModel().isEmpty(position)) {
            getModel().getPlayer().setPosition(position);
            if (getModel().isEnemy(position)) {
                getModel().getPlayer().removeLife();
                getModel().getPlayer().setTempBlockPassAbility(false);
                getModel().getPlayer().setFlamePassAbility(false);
                getModel().getPlayer().setBombPassAbility(false);

            }
            if (getModel().isLifePower(position)) {
                for(int i = 0; i< getModel().getPowers().size(); i++){
                    if(getModel().getPowers().get(i).getPosition().equals(position) && getModel().getPlayer().getLives()<3){
                        getModel().getPowers().remove(i);
                        getModel().getPlayer().addLife();
                    }
                }
            }
            if (getModel().isPointsPower(position)) {
                Random randomizer = new Random();
                for(int i = 0; i< getModel().getPowers().size(); i++){
                    if(getModel().getPowers().get(i).getPosition().equals(position)){
                        getModel().getPowers().remove(i);
                        getModel().getPlayer().incrementPoints(100 + randomizer.nextInt(400) );
                    }
                }
            }
            if (getModel().isBombPassPower(position)) {
                for(int i = 0; i< getModel().getPowers().size(); i++){
                    if(getModel().getPowers().get(i).getPosition().equals(position)){
                        getModel().getPlayer().setBombPassAbility(true);
                        getModel().getPowers().remove(i);

                    }
                }
            }
            if (getModel().isTempBlockPassPower(position)) {
                for(int i = 0; i< getModel().getPowers().size(); i++){
                    if(getModel().getPowers().get(i).getPosition().equals(position)){
                        getModel().getPlayer().setTempBlockPassAbility(true);
                        getModel().getPowers().remove(i);

                    }
                }
            }
            if (getModel().isFlamePassPower(position)) {
                for(int i = 0; i< getModel().getPowers().size(); i++){
                    if(getModel().getPowers().get(i).getPosition().equals(position)){
                        getModel().getPlayer().setFlamePassAbility(true);
                        getModel().getPowers().remove(i);

                    }
                }
            }



        }
    }




    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        if (action == GUI.ACTION.UP) movePlayerUp();
        if (action == GUI.ACTION.RIGHT) movePlayerRight();
        if (action == GUI.ACTION.DOWN) movePlayerDown();
        if (action == GUI.ACTION.LEFT) movePlayerLeft();

    }
}