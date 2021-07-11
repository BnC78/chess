package misc;

import game.Tile;

import pieces.*;

public class Start {

    public static Tile[][] asWhite() {
        Tile[][] board = emptyBoard();
        board = addRow(true, board, true);
        board = addRow(false, board, true);
        board = addPawns(true, board);
        board[5][0].setPiece(new Pawn(false));
        board[5][2].setPiece(new Pawn(false));
        board[5][3].setPiece(new Pawn(false));
        return board;
    }

    public static Tile[][] asBlack() {
        Tile[][] board = emptyBoard();
        board = addRow(true, board, false);
        board = addRow(false, board, false);
        board = addPawns(false, board);
        return board;
    }

    private static Tile[][] emptyBoard() {
        Tile[][] board = new Tile[8][8];
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                board[i][j] = new Tile(null, i, j);
            }
        }
        return board;
    }

    private static Tile[][] addRow(boolean white, Tile[][] board, boolean asWhite) {
        int row;
        if (asWhite) {
            row = (white ? 7 : 0);
        } else {
            row = (white ? 0 : 7);
        }
        board[row][0].setPiece(new Rook(white));
        board[row][1].setPiece(new Knight(white));
        board[row][2].setPiece(new Bishop(white));
        board[row][3].setPiece(asWhite ? new Queen(white) : new King(white));
        board[row][4].setPiece(asWhite ? new King(white) : new Queen(white));
        board[row][5].setPiece(new Bishop(white));
        board[row][6].setPiece(new Knight(white));
        board[row][7].setPiece(new Rook(white));
        return board;
    }

    private static Tile[][] addPawns(boolean white, Tile[][] board) {
        for (int i = 0; i < board.length; ++i) {
            board[1][i].setPiece(new Pawn(white ? false : true));
            board[6][i].setPiece(new Pawn(white ? true : false));
        }
        return board;
    }
}
