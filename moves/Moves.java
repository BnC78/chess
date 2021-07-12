package moves;

import game.Board;
import game.Cell;

public abstract class Moves {
    
    protected final Board board;
    private final Cell[][] cells;
    protected final Cell currentCell;
    protected final int row;
    protected final int column;

    protected Moves(Board board, Cell[][] cells, Cell currentCell) {
        this.board = board;
        this.cells = cells;
        this.currentCell = currentCell;
        this.row = currentCell.getRow();
        this.column = currentCell.getColumn();
    }

    public static Moves initializeMoves(Board board, Cell[][] cells, Cell currentCell) {
        switch(currentCell.getTile().getPiece().getPieceType()) {
            case BISHOP:
                return new BishopMoves(board, cells, currentCell);
            case KING:
                return new KingMoves(board, cells, currentCell);
            case KNIGHT:
                return new KnightMoves(board, cells, currentCell);
            case PAWN:
                return new PawnMoves(board, cells, currentCell);
            case QUEEN:
                return new QueenMoves(board, cells, currentCell);
            case ROOK:
                return new RookMoves(board, cells, currentCell);
            default:
                return null;
        }
    }

    protected Cell getCell(int row, int column) {
        return this.cells[row][column];
    }

    abstract public void showPossibleMoves();

    //Common moves (Rook, Queen)
    protected void checkLeft() {
        int modifier = 1;
        while ((column-modifier) >= 0 && board.isEmptyTile(row, column-modifier)) {
            getCell(row, column-modifier).possibleMove();
            ++modifier;
        }
        if ((column-modifier) >= 0 && board.isEnemyTile(row, column-modifier)) {
            getCell(row, column-modifier).possibleAttack();
        }
    }
    
    protected void checkRight() {
        int modifier = 1;
        while ((column+modifier) <= 7 && board.isEmptyTile(row, column+modifier)) {
            getCell(row, column+modifier).possibleMove();
            ++modifier;
        }
        if ((column+modifier) <= 7 && board.isEnemyTile(row, column+modifier)) {
            getCell(row, column+modifier).possibleAttack();
        }
    }
    
    protected void checkUp() {
        int modifier = 1;
        while ((row-modifier) >= 0 && board.isEmptyTile(row-modifier, column)) {
            getCell(row-modifier, column).possibleMove();
            ++modifier;
        }
        if ((row-modifier) >= 0 && board.isEnemyTile(row-modifier, column)) {
            getCell(row-modifier, column).possibleAttack();
        }
    }
    
    protected void checkDown() {
        int modifier = 1;
        while ((row+modifier) <= 7 && board.isEmptyTile(row+modifier, column)) {
            getCell(row+modifier, column).possibleMove();
            ++modifier;
        }
        if ((row+modifier) <= 7 && board.isEnemyTile(row+modifier, column)) {
            getCell(row+modifier, column).possibleAttack();
        }
    }

    //Common moves (Bishop, Queen)
    protected void checkUpLeft() {
        int modifier = 1;
        while ((row-modifier) >= 0 && (column-modifier) >= 0 && board.isEmptyTile(row-modifier, column-modifier)) {
            getCell(row-modifier, column-modifier).possibleMove();
            ++modifier;
        }
        if ((row-modifier) >= 0 && (column-modifier) >= 0 && board.isEnemyTile(row-modifier, column-modifier)) {
            getCell(row-modifier, column-modifier).possibleAttack();
        }
    }

    protected void checkUpRight() {
        int modifier = 1;
        while ((row-modifier) >= 0 && (column+modifier) <= 7 && board.isEmptyTile(row-modifier, column+modifier)) {
            getCell(row-modifier, column+modifier).possibleMove();
            ++modifier;
        }
        if ((row-modifier) >= 0 && (column+modifier) <= 7 && board.isEnemyTile(row-modifier, column+modifier)) {
            getCell(row-modifier, column+modifier).possibleAttack();
        }
    }

    protected void checkDownLeft() {
        int modifier = 1;
        while ((row+modifier) <= 7 && (column-modifier) >= 0 && board.isEmptyTile(row+modifier, column-modifier)) {
            getCell(row+modifier, column-modifier).possibleMove();
            ++modifier;
        }
        if ((row+modifier) <= 7 && (column-modifier) >= 0 && board.isEnemyTile(row+modifier, column-modifier)) {
            getCell(row+modifier, column-modifier).possibleAttack();
        }
    }

    protected void checkDownRight() {
        int modifier = 1;
        while ((row+modifier) <= 7 && (column+modifier) <= 7 && board.isEmptyTile(row+modifier, column+modifier)) {
            getCell(row+modifier, column+modifier).possibleMove();
            ++modifier;
        }
        if ((row+modifier) <= 7 && (column+modifier) <= 7 && board.isEnemyTile(row+modifier, column+modifier)) {
            getCell(row+modifier, column+modifier).possibleAttack();
        }
    }
}
