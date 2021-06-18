package game;

import javax.swing.JButton;
import javax.swing.JPanel;

import misc.Start;

import java.awt.GridLayout;

public class Board extends JPanel {

    public JButton[][] tiles;

    public Board(boolean play_as_white) {
        createBoard(play_as_white);
    }

    private void createBoard(boolean play_as_white) {
        this.tiles = (play_as_white ? Start.asWhite() : Start.asBlack());
        this.setLayout(new GridLayout(8, 8));
        this.setVisible(true);
    }
}
