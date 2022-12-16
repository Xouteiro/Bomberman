package feupL15G01.controller;

import feupL15G01.Game;
import feupL15G01.gui.GUI;
import feupL15G01.model.game.board.Board;
import feupL15G01.model.menu.GameOver;
import feupL15G01.model.menu.Menu;
import feupL15G01.model.menu.Win;
import feupL15G01.states.GameOverState;
import feupL15G01.states.MenuState;
import feupL15G01.states.WinState;

import java.io.IOException;

public class BoardController extends GameController {
    private final PlayerController playerController;
    private final EnemyController enemyController;

    private final BombController bombController;

    public BoardController(Board board) {
        super(board);

        this.playerController = new PlayerController(board);
        this.enemyController = new EnemyController(board);
        this.bombController = new BombController(board);
    }

    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.QUIT) {
            game.setState(new MenuState(new Menu()));
            //game.setState(new GameOverState(new GameOver()));
            //game.setState(new WinState(new Win()));
        }
        else if (getModel().getPlayer().getPosition().equals(getModel().getDoor().getPosition()) && getModel().getDoor().isAvailable()) {
            int flag = 0;
            for (int i = 0; i < getModel().getPowers().size(); i++) {
                if (getModel().getPowers().get(i).getPosition().equals(getModel().getPlayer().getPosition())) {
                    int j = 0;
                    while (j < getModel().getTempBlocks().size()) {
                        if (getModel().getTempBlocks().get(j).getPosition().equals(getModel().getPlayer().getPosition())) {
                            flag = 1;
                            break;
                        }
                        j++;
                    }
                    if (flag == 0) {
                        game.setState(new WinState(new Win()));
                    }
                }
            }
        }
        else if (getModel().getPlayer().getLives() == 0) {
            game.setState(new GameOverState(new GameOver()));
        }
        else {
            playerController.step(game, action, time);
            enemyController.step(game, action, time);
            bombController.step(game, action, time);
        }
    }
}



