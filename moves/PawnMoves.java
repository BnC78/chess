package moves;

import game.Board;
import game.Cell;
import pieces.Pawn;

public class PawnMoves extends Moves {

    public PawnMoves(Board board, Cell[][] cells, Cell currentCell) {
        super(board, cells, currentCell);
    }

    @Override
    public void showPossibleMoves() {
        int modifier = -1;
        if (!board.isAttackingUpwards()) {
            modifier = 1;
        }
        if (board.isEmptyTile(row+modifier, column)) {
            getCell(row+modifier, column).possibleMove();
            if (!((Pawn) currentCell.getTile().getPiece()).isStarted() && board.isEmptyTile(row+2*modifier, column)) {
                getCell(row+2*modifier, column).possibleMove();
            }
        }
        if (column > 0 && board.isEnemyTile(row+modifier, column-1)) {
            getCell(row+modifier, column-1).possibleAttack();
        }
        if (column < 7 && board.isEnemyTile(row+modifier, column+1)) {
            getCell(row+modifier, column+1).possibleAttack();
        }
    }
    

}
