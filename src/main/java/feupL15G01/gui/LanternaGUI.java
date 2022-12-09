package feupL15G01.gui;

import java.awt.image.BufferedImage;
import java.io.IOException;


import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.graphics.TextImage;
import feupL15G01.model.Position;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;


import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

public class LanternaGUI implements GUI {
    private final Screen screen;

    public LanternaGUI(Screen screen) throws IOException {
        this.screen = screen;
    }

    public LanternaGUI(int width, int height) throws IOException, FontFormatException, URISyntaxException {
        AWTTerminalFontConfiguration fontConfig = loadSquareFont();
        Terminal terminal = createTerminal(width, height, fontConfig);

        this.screen = createScreen(terminal);
    }

    private Screen createScreen(Terminal terminal) throws IOException {
        final Screen screen;
        screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        return screen;
    }

    private Terminal createTerminal(int width, int height, AWTTerminalFontConfiguration fontConfig) throws IOException {
        TerminalSize terminalSize = new TerminalSize(width -1, height );
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        terminalFactory.setForceAWTOverSwing(true);
        terminalFactory.setTerminalEmulatorFontConfiguration(fontConfig);
        Terminal terminal = terminalFactory.createTerminal();
        return terminal;
    }

    private AWTTerminalFontConfiguration loadSquareFont() throws URISyntaxException, FontFormatException, IOException {
        URL resource = getClass().getClassLoader().getResource("fonts/square.ttf");
        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        Font loadedFont = font.deriveFont(Font.PLAIN, 20);
        //Font loadedFont = new Font("Courier",Font.BOLD, 18); //teste antigo é para apagar
        AWTTerminalFontConfiguration fontConfig = AWTTerminalFontConfiguration.newInstance(loadedFont);


        return fontConfig;
    }

    BufferedImage bombImage = ImageIO.read(getClass().getClassLoader().getResource("images/16bit_bomb1.png"));
    BufferedImage playerImage = ImageIO.read(getClass().getClassLoader().getResource("images/power_2.png"));
    BufferedImage tempblockImage = ImageIO.read(getClass().getClassLoader().getResource("images/temp_block.png"));
    BufferedImage enemyImage = ImageIO.read(getClass().getClassLoader().getResource("images/enemy_f.png"));
    BufferedImage fixblockImage = ImageIO.read(getClass().getClassLoader().getResource("images/fix_block.png"));


    public ACTION getNextAction() throws IOException {
        KeyStroke keyStroke = screen.pollInput();
        if (keyStroke == null) return ACTION.NONE;

        if (keyStroke.getKeyType() == KeyType.EOF) return ACTION.QUIT;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'q') return ACTION.QUIT;

        if (keyStroke.getKeyType() == KeyType.ArrowUp) return ACTION.UP;
        if (keyStroke.getKeyType() == KeyType.ArrowRight) return ACTION.RIGHT;
        if (keyStroke.getKeyType() == KeyType.ArrowDown) return ACTION.DOWN;
        if (keyStroke.getKeyType() == KeyType.ArrowLeft) return ACTION.LEFT;

        if (keyStroke.getKeyType() == KeyType.Enter) return ACTION.SELECT;

        return ACTION.NONE;
    }

    @Override
    public void drawPlayer(Position position) {
        drawElement(position.getX(),position.getY(), playerImage);
    }

    @Override
    public void drawWall(Position position) {
        drawElement(position.getX(), position.getY(), fixblockImage);
    }

    @Override
    public void drawEnemy(Position position) {
        drawElement(position.getX(), position.getY(), enemyImage);
    }

    @Override
    public void drawFixBlock(Position position) {
        drawElement(position.getX(), position.getY(), fixblockImage);
    }

    @Override
    public void drawTempBlock(Position position) {
        drawElement(position.getX(), position.getY(), tempblockImage);
    }

    @Override
    public void drawPower(Position position) {
        drawElement(position.getX(), position.getY(), playerImage);
    }

    @Override
    public void drawText(Position position, String text, String color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(position.getX(), position.getY(), text);
    }

    private void drawElement(int x, int y, BufferedImage i) {
        TextGraphics tg = screen.newTextGraphics();
        tg.
    }

    @Override
    public void clear() {
        screen.clear();
    }

    @Override
    public void refresh() throws IOException {
        screen.refresh();
    }

    @Override
    public void close() throws IOException {
        screen.close();
    }
}