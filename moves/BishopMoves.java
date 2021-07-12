package moves;

import game.Board;
import game.Cell;

public class BishopMoves extends Moves {

    public BishopMoves(Board board, Cell[][] cells, Cell currentCell) {
        super(board, cells, currentCell);
    }

    @Override
    public void showPossibleMoves() {
        checkUpLeft();
        checkUpRight();
        checkDownLeft();
        checkDownRight();
    }

}
