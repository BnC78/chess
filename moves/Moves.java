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
}
