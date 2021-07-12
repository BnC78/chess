package moves;

import game.Board;
import game.Cell;

public class KingMoves extends Moves {

    public KingMoves(Board board, Cell[][] cells, Cell currentCell) {
        super(board, cells, currentCell);
    }

    @Override
    public void showPossibleMoves() {
        for (int i = -1; i <= 1; ++i) {
            for (int j = -1; j <= 1; ++j) {
                checkCell(row+i, column+j);
            }
        }
    }
}
