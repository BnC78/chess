package game;

import javax.swing.JButton;
import javax.swing.JPanel;

import misc.Start;

import java.awt.GridLayout;
import java.awt.Color;

public class Board extends JPanel {

    public JButton[][] tiles;

    public Board(boolean asWhite) {
        createBoard(asWhite);
    }

    private void createBoard(boolean asWhite) {
        this.tiles = (asWhite ? Start.asWhite() : Start.asBlack());
        for (int i = 0; i < tiles.length; ++i) {
            for (int j = 0; j < tiles[i].length; ++j) {
                tiles[i][j].setBackground(((i + j) % 2 == 0) ? Color.WHITE : Color.DARK_GRAY);
                this.add(tiles[i][j]);
            }
        }
        this.setLayout(new GridLayout(8, 8));
        this.setVisible(true);
    }
}
