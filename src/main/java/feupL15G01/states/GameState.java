package feupL15G01.states;

import feupL15G01.controller.BoardController;
import feupL15G01.controller.Controller;
import feupL15G01.model.game.board.Board;
import feupL15G01.viewer.Viewer;
import feupL15G01.viewer.game.GameViewer;

public class GameState extends State<Board> {
    public GameState(Board board) {
        super(board);
    }

    @Override
    protected Viewer<Board> getViewer() {
        return new GameViewer(getModel());
    }

    @Override
    protected Controller<Board> getController() {
        return new BoardController(getModel());
    }
}