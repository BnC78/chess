package game;

import javax.swing.JButton;
import javax.swing.JPanel;

import misc.Player;
import pieces.ChessPiece;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
                Cell cell = new Cell(i, j);
                cell.setBackground(((i + j) % 2 == 0) ? Color.WHITE : Color.DARK_GRAY);
                ChessPiece piece = board.getTile(i, j).getPiece();
                if (piece != null) {
                    cell.setIcon(piece.getIcon());
                }
                cell.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Cell cell = (Cell) e.getSource();
                        int row = cell.getRow();
                        int column = cell.getColumn();
                    }
                });
                this.add(cell);
            }
        }
        this.setLayout(new GridLayout(8, 8));
        this.setVisible(true);
    }
}
