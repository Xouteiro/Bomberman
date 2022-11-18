package feupL15G01.gui;

import feupL15G01.model.Position;
import java.io.IOException;

public interface GUI {
    ACTION getNextAction() throws IOException;

    void drawPlayer(Position position);

    void drawWall(Position position);

    void drawMonster(Position position);

    void drawFixedBlock(Position position);

    void drawTempBlocks(Position position);

    void drawPowers(Position position /* , image */ );

    void drawText(Position position, String text, String color);

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

    enum ACTION {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT}
}
