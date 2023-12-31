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

        if (getModel().isEmptyForPlayer(position)) {
            getModel().getPlayer().setPosition(position);
            getModel().getPlayer().setOnTopOfTempBlock(false);
            if (getModel().isEnemy(position)) {
                getModel().getPlayer().removeLife();
                getModel().getPlayer().setTempBlockPassAbility(false);
                getModel().getPlayer().setFlamePassAbility(false);
                getModel().getPlayer().setBombPassAbility(false);

            }

            if (getModel().isTempBlock(position)) {
                getModel().getPlayer().setOnTopOfTempBlock(true);
            }
            if (getModel().isLifePower(position)) {
                int flag = 0;
                for (int i = 0; i < getModel().getPowers().size(); i++) {
                    if (getModel().getPowers().get(i).getPosition().equals(position) && getModel().getPlayer().getLives() < 3) {
                        int j = 0;
                        while (j < getModel().getTempBlocks().size()) {
                            if (getModel().getTempBlocks().get(j).getPosition().equals(position)) {
                                flag = 1;
                                break;
                            }
                            j++;
                        }
                        if (flag == 0) {
                            getModel().getPlayer().addLife();
                            getModel().getPowers().remove(i);
                        }

                    }
                }
            }
            if (getModel().isPointsPower(position)) {
                Random randomizer = new Random();
                int flag = 0;
                for (int i = 0; i < getModel().getPowers().size(); i++) {
                    if (getModel().getPowers().get(i).getPosition().equals(position)) {
                        int j = 0;
                        while (j < getModel().getTempBlocks().size()) {
                            if (getModel().getTempBlocks().get(j).getPosition().equals(position)) {
                                flag = 1;
                                break;
                            }
                            j++;
                        }
                        if (flag == 0) {
                            getModel().getPlayer().incrementPoints(100 + randomizer.nextInt(400));
                            getModel().getPowers().remove(i);
                        }

                    }
                }
            }
            if (getModel().isBombPassPower(position)) {
                int flag = 0;
                for (int i = 0; i < getModel().getPowers().size(); i++) {
                    if (getModel().getPowers().get(i).getPosition().equals(position)) {
                        int j = 0;
                        while (j < getModel().getTempBlocks().size()) {
                            if (getModel().getTempBlocks().get(j).getPosition().equals(position)) {
                                flag = 1;
                                break;
                            }
                            j++;
                        }
                        if (flag == 0) {
                            getModel().getPlayer().setBombPassAbility(true);
                            getModel().getPowers().remove(i);
                        }
                    }
                }
            }
            if (getModel().isTempBlockPassPower(position)) {
                int flag = 0;
                for (int i = 0; i < getModel().getPowers().size(); i++) {
                    if (getModel().getPowers().get(i).getPosition().equals(position)) {
                        int j = 0;
                        while (j < getModel().getTempBlocks().size()) {
                            if (getModel().getTempBlocks().get(j).getPosition().equals(position)) {
                                flag = 1;
                                break;
                            }
                            j++;
                        }
                        if (flag == 0) {
                            getModel().getPlayer().setTempBlockPassAbility(true);
                            getModel().getPowers().remove(i);
                        }
                    }
                }
            }
            if (getModel().isFlamePassPower(position)) {
                int flag = 0;
                for (int i = 0; i < getModel().getPowers().size(); i++) {
                    if (getModel().getPowers().get(i).getPosition().equals(position)) {
                        int j = 0;
                        while (j < getModel().getTempBlocks().size()) {
                            if (getModel().getTempBlocks().get(j).getPosition().equals(position)) {
                                flag = 1;
                                break;
                            }
                            j++;
                        }
                        if (flag == 0) {
                            getModel().getPlayer().setFlamePassAbility(true);
                            getModel().getPowers().remove(i);
                        }
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