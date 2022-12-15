package feupL15G01.states;

import feupL15G01.controller.Controller;
import feupL15G01.controller.WinController;
import feupL15G01.model.menu.Win;
import feupL15G01.viewer.Viewer;
import feupL15G01.viewer.menu.WinViewer;

public class WinState extends State<Win>{

    public WinState(Win model) {
        super(model);
    }

    @Override
    protected Viewer<Win> getViewer() {
        return new WinViewer(getModel());
    }

    @Override
    protected Controller<Win> getController() {
        return new WinController(getModel());
    }
}
