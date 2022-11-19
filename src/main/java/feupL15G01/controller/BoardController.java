package feupL15G01.controller;

import feupL15G01.Game;
import feupL15G01.gui.GUI;
import feupL15G01.model.game.board.Board;
import feupL15G01.model.menu.Menu;
import feupL15G01.states.MenuState;

import java.io.IOException;

public class BoardController extends GameController {
    private final PlayerController playerController;
    private final EnemyController enemyController;

    public BoardController(Board board) {
        super(board);

        this.playerController = new PlayerController(board);
        this.enemyController = new EnemyController(board);
    }

    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.QUIT || getModel().getPlayer().getBombs() == 0) //getBombs tem que ser getlifes aqui
            game.setState(new MenuState(new Menu()));
        else {
            playerController.step(game, action, time);
            enemyController.step(game, action, time);
        }
    }
}