package feupL15G01.states;

import feupL15G01.controller.Controller;
import feupL15G01.controller.GameOverController;
import feupL15G01.controller.WinController;
import feupL15G01.model.menu.GameOver;
import feupL15G01.model.menu.Win;
import feupL15G01.viewer.Viewer;
import feupL15G01.viewer.menu.GameOverViewer;
import feupL15G01.viewer.menu.WinViewer;

public class GameOverState extends State<GameOver>{
    public GameOverState(GameOver model) {
        super(model);
    }

    @Override
    protected Viewer<GameOver> getViewer() {
        return new GameOverViewer(getModel());
    }

    @Override
    protected Controller<GameOver> getController() {
        return new GameOverController(getModel());
    }
}
