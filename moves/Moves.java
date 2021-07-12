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
        switch(board.getTile(currentCell.getRow(), currentCell.getColumn()).getPiece().getPieceType()) {
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

    protected boolean checkCell(int row, int column) {
        if (column < 0 || column > 7 || row < 0 || row > 7) {
            return false;
        }
        if (board.isEmptyTile(row, column)) {
            getCell(row, column).possibleMove();
            return true;
        } else if (board.isEnemyTile(row, column)) {
            getCell(row, column).possibleAttack();
        }
        return false;
    }

    //Common methods (Rook, Queen)
    protected void checkLeft() {
        int modifier = 1;
        while (checkCell(row, column-modifier)) {
            ++modifier;
        }
    }
    
    protected void checkRight() {
        int modifier = 1;
        while (checkCell(row, column+modifier)) {
            ++modifier;
        }
    }
    
    protected void checkUp() {
        int modifier = 1;
        while (checkCell(row-modifier, column)) {
            ++modifier;
        }
    }
    
    protected void checkDown() {
        int modifier = 1;
        while (checkCell(row+modifier, column)) {
            ++modifier;
        }
    }

    //Common methods (Bishop, Queen)
    protected void checkUpLeft() {
        int modifier = 1;
        while (checkCell(row-modifier, column-modifier)) {
            ++modifier;
        }
    }

    protected void checkUpRight() {
        int modifier = 1;
        while (checkCell(row-modifier, column+modifier)) {
            ++modifier;
        }
    }

    protected void checkDownLeft() {
        int modifier = 1;
        while (checkCell(row+modifier, column-modifier)) {
            ++modifier;
        }
    }

    protected void checkDownRight() {
        int modifier = 1;
        while (checkCell(row+modifier, column+modifier)) {
            ++modifier;
        }
    }
}
