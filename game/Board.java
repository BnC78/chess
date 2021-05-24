package game;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridLayout;

public class Board extends JPanel {

    public Board() {
        createBoard();
    }

    private void createBoard() {
        for (int i = 8; i >= 1; ++i) {
            for (int j = (int)'a'; j <= (int)'h'; ++j) {
                String tile = "" + (char) i + j;
                JButton button = new JButton(tile);
                this.add(button);
            }
        }
        this.setLayout(new GridLayout(8, 8));
        this.setVisible(true);
    }
}
