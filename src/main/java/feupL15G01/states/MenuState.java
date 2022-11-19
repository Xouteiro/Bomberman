package feupL15G01.states;

import feupL15G01.controller.Controller;
import feupL15G01.controller.MenuController;
import feupL15G01.model.menu.Menu;
import feupL15G01.viewer.Viewer;
import feupL15G01.viewer.menu.MenuViewer;

public class MenuState extends State<Menu> {
    public MenuState(Menu model) {
        super(model);
    }

    @Override
    protected Viewer<Menu> getViewer() {
        return new MenuViewer(getModel());
    }

    @Override
    protected Controller<Menu> getController() {
        return new MenuController(getModel());
    }
}