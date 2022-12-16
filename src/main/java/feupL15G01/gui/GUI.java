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

    void drawDoor(Position position);

    void drawText(Position position, String text, String color);

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

    void drawLifePower(Position position);

    void drawPointsPower(Position position);

    void drawBombPassPower(Position position);

    void drawTempBlockPassPower(Position position);

    void drawFlamePassPower(Position position);

    void drawExplosion(Position position);


    enum ACTION {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT, BOMB}
}
