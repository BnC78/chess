package misc;

import javax.swing.JButton;
import java.awt.Color;

import pieces.*;

public class Start {

    public static JButton[][] asWhite() {
        JButton[][] board = emptyBoard();
        board = addRow(Color.WHITE, board, true);
        board = addRow(Color.BLACK, board, true);
        for (int i = 0; i < board.length; ++i) {
            board[1][i] = new Pawn(Color.BLACK);
            board[6][i] = new Pawn(Color.WHITE);
        }
        return board;
    }

    public static JButton[][] asBlack() {
        JButton[][] board = emptyBoard();
        board = addRow(Color.WHITE, board, false);
        board = addRow(Color.BLACK, board, false);
        for (int i = 0; i < board.length; ++i) {
            board[1][i] = new Pawn(Color.WHITE);
            board[6][i] = new Pawn(Color.BLACK);
        }
        return board;
    }

    public static JButton[][] emptyBoard() {
        JButton[][] board = new JButton[8][8];
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                board[i][j] = new JButton();
            }
        }
        return board;
    }

    public static JButton[][] addRow(Color color, JButton[][] board, boolean asWhite) {
        int row;
        if (asWhite) {
            if (color == Color.WHITE) {
                row = 7;
            } else {
                row = 0;
            }
        } else {
            if (color == Color.WHITE) {
                row = 0;
            } else {
                row = 7;
            }
        }
        board[row][0] = new Rook(color);
        board[row][1] = new Knight(color);
        board[row][2] = new Bishop(color);
        board[row][3] = asWhite ? new Queen(color) : new King(color);
        board[row][4] = asWhite ? new King(color) : new Queen(color);
        board[row][5] = new Bishop(color);
        board[row][6] = new Knight(color);
        board[row][7] = new Rook(color);
        return board;
    }
}
