package moves;

import game.Board;
import game.Cell;

public abstract class Moves {
    
    private final Board board;
    private final Cell[][] cells;
    private final Cell currentCell;

    protected Moves(Board board, Cell[][] cells, Cell currentCell) {
        this.board = board;
        this.cells = cells;
        this.currentCell = currentCell;
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

    protected Board getBoard() {
        return this.board;
    }

    protected Cell getCell(int row, int column) {
        return this.cells[row][column];
    }

    protected Cell getCurrentCell() {
        return this.currentCell;
    }

    abstract public void showPossibleMoves();
}
