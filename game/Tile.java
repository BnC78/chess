package game;

import pieces.ChessPiece;

public class Tile {
    
    private ChessPiece piece;
    private int row;
    private int column;

    public Tile(ChessPiece piece, int row, int column) {
        this.piece = piece;
        this.row = row;
        this.column = column;
    }

    public ChessPiece getPiece() {
        return this.piece;
    }

    public void setPiece(ChessPiece piece) {
        this.piece = piece;
    }

    public boolean isEmpty() {
        return this.piece == null;
    }

    public void setEmpty() {
        setPiece(null);
    }

    public int getRow() {
        return this.row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return this.column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}
