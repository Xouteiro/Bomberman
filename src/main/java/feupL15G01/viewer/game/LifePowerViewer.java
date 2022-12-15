package feupL15G01.viewer.game;

import feupL15G01.gui.GUI;
import feupL15G01.model.game.elements.Power;

public class LifePowerViewer implements ElementViewer<Power>{
    @Override
    public void draw(Power power, GUI gui) {
        gui.drawLifePower(power.getPosition());
    }
}
