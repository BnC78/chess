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
    
    public void checkLeft() {
        int modifier = 1;
        while ((column-modifier) >= 0 && board.isEmptyTile(row, column-modifier)) {
            getCell(row, column-modifier).possibleMove();
            ++modifier;
        }
        if ((column-modifier) >= 0 && board.isEnemyTile(row, column-modifier)) {
            getCell(row, column-modifier).possibleAttack();
        }
    }
    
    public void checkRight() {
        int modifier = 1;
        while ((column+modifier) <= 7 && board.isEmptyTile(row, column+modifier)) {
            getCell(row, column+modifier).possibleMove();
            ++modifier;
        }
        if ((column+modifier) <= 7 && board.isEnemyTile(row, column+modifier)) {
            getCell(row, column+modifier).possibleAttack();
        }
    }
    
    public void checkUp() {
        int modifier = 1;
        while ((row-modifier) >= 0 && board.isEmptyTile(row-modifier, column)) {
            getCell(row-modifier, column).possibleMove();
            ++modifier;
        }
        if ((row-modifier) >= 0 && board.isEnemyTile(row-modifier, column)) {
            getCell(row-modifier, column).possibleAttack();
        }
    }
    
    public void checkDown() {
        int modifier = 1;
        while ((row+modifier) <= 7 && board.isEmptyTile(row+modifier, column)) {
            getCell(row+modifier, column).possibleMove();
            ++modifier;
        }
        if ((row+modifier) <= 7 && board.isEnemyTile(row+modifier, column)) {
            getCell(row+modifier, column).possibleAttack();
        }
    }

}
