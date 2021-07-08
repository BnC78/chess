package game;

import javax.swing.JButton;
import javax.swing.JPanel;

import misc.Player;
import pieces.ChessPiece;

import java.awt.Color;
import java.awt.GridLayout;

public class Table extends JPanel {
    
    private Board board;
    private Player currentPlayer;

    public Table() {
        this.board = new Board(true);
        this.currentPlayer = Player.WHITE;
        this.createTable();
    }

    public void createTable() {
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                JButton cell = new JButton();
                cell.setBackground(((i + j) % 2 == 0) ? Color.WHITE : Color.DARK_GRAY);
                ChessPiece piece = board.getTile(i, j).getPiece();
                if (piece != null) {
                    cell.setIcon(piece.getIcon());
                }
                this.add(cell);
            }
        }
        this.setLayout(new GridLayout(8, 8));
        this.setVisible(true);
    }
}
