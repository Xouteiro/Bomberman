package feupL15G01.controller;

import feupL15G01.Game;
import feupL15G01.gui.GUI;
import feupL15G01.model.game.board.RandomBoardBuilder;
import feupL15G01.model.menu.Menu;
import feupL15G01.model.menu.Win;
import feupL15G01.states.GameState;
import feupL15G01.states.MenuState;

import java.io.IOException;

public class WinController extends Controller<Win>{
    public WinController(Win model) {
        super(model);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case UP:
                getModel().previousEntry();
                break;
            case DOWN:
                getModel().nextEntry();
                break;
            case SELECT:
                if (getModel().isSelectedExit()) game.setState(null);
                if(getModel().isSelectedBackToMainMenu()) game.setState(new MenuState(new Menu()));


        }
    }
}
