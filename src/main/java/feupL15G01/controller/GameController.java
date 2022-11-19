package feupL15G01.controller;


import feupL15G01.model.game.board.Board;

public abstract class GameController extends Controller<Board> {
    public GameController(Board board) {
        super(board);
    }
}
