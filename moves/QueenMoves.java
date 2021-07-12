package moves;

import game.Board;
import game.Cell;

public class QueenMoves extends Moves {

    public QueenMoves(Board board, Cell[][] cells, Cell currentCell) {
        super(board, cells, currentCell);
    }

    @Override
    public void showPossibleMoves() {
        checkLeft();
        checkRight();
        checkUp();
        checkDown();
        checkUpLeft();
        checkUpRight();
        checkDownLeft();
        checkDownRight();
    }
    
}
