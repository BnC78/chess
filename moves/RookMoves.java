package moves;

import game.Board;
import game.Cell;

public class RookMoves extends Moves {

    public RookMoves(Board board, Cell[][] cells, Cell currentCell) {
        super(board, cells, currentCell);
    }

    @Override
    public void showPossibleMoves() {
        checkLeft();
        checkRight();
        checkUp();
        checkDown();
    }

}
