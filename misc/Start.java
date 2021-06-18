package misc;

import javax.swing.JButton;

import pieces.*;

public class Start {
    
    private static final Rook whiteRook = new Rook(Color.WHITE);
    private static final Knight whiteKnight = new Knight(Color.WHITE);
    private static final Bishop whiteBishop = new Bishop(Color.WHITE);
    private static final King whiteKing = new King(Color.WHITE);
    private static final Queen whiteQueen = new Queen(Color.WHITE);
    private static final Rook blackRook = new Rook(Color.BLACK);
    private static final Knight blackKnight = new Knight(Color.BLACK);;
    private static final Bishop blackBishop = new Bishop(Color.BLACK);;
    private static final King blackKing = new King(Color.BLACK);;
    private static final Queen blackQueen = new Queen(Color.BLACK);;


    public static JButton[][] asWhite() {
        JButton[][] board = {
            {blackRook, blackKnight, blackBishop, blackQueen, blackKing, blackBishop, blackKnight, blackRook},
            {}, {}, {}, {}, {}, {}, //6 empty rows
            {whiteRook, whiteKnight, whiteBishop, whiteQueen, whiteKing, whiteBishop, whiteKnight, whiteRook} 
        };
        for (int i = 0; i < board.length; ++i) {
            board[1][i] = new Pawn(Color.BLACK);
            board[6][i] = new Pawn(Color.WHITE);
        }
        return board;
    }

    public static JButton[][] asBlack() {
        JButton[][] board = {
            {whiteRook, whiteKnight, whiteBishop, whiteQueen, whiteKing, whiteBishop, whiteKnight, whiteRook},
            {}, {}, {}, {}, {}, {}, //6 empty rows
            {blackRook, blackKnight, blackBishop, blackQueen, blackKing, blackBishop, blackKnight, blackRook}
        };
        for (int i = 0; i < board.length; ++i) {
            board[1][i] = new Pawn(Color.WHITE);
            board[6][i] = new Pawn(Color.BLACK);
        }
        return board;
    }
}
