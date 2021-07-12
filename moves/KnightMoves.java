package moves;

import game.Board;
import game.Cell;

public class KnightMoves extends Moves {

    public KnightMoves(Board board, Cell[][] cells, Cell currentCell) {
        super(board, cells, currentCell);
    }

    @Override
    public void showPossibleMoves() {
        checkCell(row-2, column-1);
        checkCell(row-2, column+1);
        checkCell(row-1, column-2);
        checkCell(row-1, column+2);
        checkCell(row+1, column-2);
        checkCell(row+1, column+2);
        checkCell(row+2, column-1);
        checkCell(row+2, column+1);
    }
    

}
