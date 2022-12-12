package feupL15G01.gui;

import feupL15G01.model.Position;
import java.io.IOException;

public interface GUI {
    ACTION getNextAction() throws IOException;

    void drawPlayer(Position position);

    void drawBomb(Position position);

    void drawWall(Position position);

    void drawEnemy(Position position);

    void drawFixBlock(Position position);

    void drawTempBlock(Position position);

    void drawPower(Position position);

    void drawDoor(Position position);

    void drawText(Position position, String text, String color);

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

    enum ACTION {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT, BOMB}
}
