package feupL15G01.viewer.game;

import feupL15G01.gui.GUI;
import feupL15G01.model.game.elements.Door;
import feupL15G01.model.game.elements.Power;

public class DoorViewer implements ElementViewer<Door>{
    @Override
    public void draw(Door door, GUI gui) {
        gui.drawDoor(door.getPosition());
    }
}
