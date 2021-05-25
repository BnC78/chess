package game;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

public class Board extends JPanel {

    public JButton[][] tiles;
    private Image whitePawn;
    private Image whiteRook;
    private Image whiteKnight;
    private Image whiteBishop;
    private Image whiteKing;
    private Image whiteQueen;
    private Image blackPawn;
    private Image blackRook;
    private Image blackKnight;
    private Image blackBishop;
    private Image blackKing;
    private Image blackQueen;

    public Board(boolean play_as_white) {
        readImages();
        createBoard(play_as_white);
    }

    private void readImages() {
        try {
            whitePawn   = ImageIO.read(new File("whitePawn.png")).getScaledInstance(80, 80, Image.SCALE_FAST);
            whiteRook   = ImageIO.read(new File("whiteRook.png")).getScaledInstance(80, 80, Image.SCALE_FAST);
            whiteKnight = ImageIO.read(new File("whiteKnight.png")).getScaledInstance(80, 80, Image.SCALE_FAST);
            whiteBishop = ImageIO.read(new File("whiteBishop.png")).getScaledInstance(80, 80, Image.SCALE_FAST);
            whiteKing   = ImageIO.read(new File("whiteKing.png")).getScaledInstance(80, 80, Image.SCALE_FAST);
            whiteQueen  = ImageIO.read(new File("whiteQueen.png")).getScaledInstance(80, 80, Image.SCALE_FAST);
            blackPawn   = ImageIO.read(new File("blackPawn.png")).getScaledInstance(80, 80, Image.SCALE_FAST);
            blackRook   = ImageIO.read(new File("blackRook.png")).getScaledInstance(80, 80, Image.SCALE_FAST);
            blackKnight = ImageIO.read(new File("blackKnight.png")).getScaledInstance(80, 80, Image.SCALE_FAST);
            blackBishop = ImageIO.read(new File("blackBishop.png")).getScaledInstance(80, 80, Image.SCALE_FAST);
            blackKing   = ImageIO.read(new File("blackKing.png")).getScaledInstance(80, 80, Image.SCALE_FAST);
            blackQueen  = ImageIO.read(new File("blackQueen.png")).getScaledInstance(80, 80, Image.SCALE_FAST);
        } catch (IOException ex) {
            System.err.println("Image import failed! Program will shut down");
            System.exit(1);
        }
    }

    private void createBoard(boolean play_as_white) {
        tiles = new JButton[8][8];
        for (int i = 8; i >= 1; --i) {
            for (int j = (int)'a'; j <= (int)'h'; ++j) {
                JButton button = new JButton();
                this.add(button);
                tiles[8 - i][j - (int)'a'] = button;
            }
        }
        this.setLayout(new GridLayout(8, 8));
        this.setVisible(true);
        putOnChessPieces(play_as_white);
    }

    private void putOnChessPieces(boolean play_as_white) {
        if (play_as_white) {
            putOnWhitePieces(true);
            putOnBlackPieces(false);
        } else {
            putOnWhitePieces(false);
            putOnBlackPieces(true);
        }
    }

    private void putOnWhitePieces(boolean player) {
        if (player) {
            for (int i = 0; i < 8; ++i) {
                tiles[6][i].setIcon(new ImageIcon(whitePawn));
            }
            tiles[7][0].setIcon(new ImageIcon(whiteRook));
            tiles[7][7].setIcon(new ImageIcon(whiteRook));
            tiles[7][1].setIcon(new ImageIcon(whiteKnight));
            tiles[7][6].setIcon(new ImageIcon(whiteKnight));
            tiles[7][2].setIcon(new ImageIcon(whiteBishop));
            tiles[7][5].setIcon(new ImageIcon(whiteBishop));
            tiles[7][3].setIcon(new ImageIcon(whiteQueen));
            tiles[7][4].setIcon(new ImageIcon(whiteKing));
        } else {
            for (int i = 0; i < 8; ++i) {
                tiles[1][i].setIcon(new ImageIcon(whitePawn));
            }
            tiles[0][0].setIcon(new ImageIcon(whiteRook));
            tiles[0][7].setIcon(new ImageIcon(whiteRook));
            tiles[0][1].setIcon(new ImageIcon(whiteKnight));
            tiles[0][6].setIcon(new ImageIcon(whiteKnight));
            tiles[0][2].setIcon(new ImageIcon(whiteBishop));
            tiles[0][5].setIcon(new ImageIcon(whiteBishop));
            tiles[0][3].setIcon(new ImageIcon(whiteQueen));
            tiles[0][4].setIcon(new ImageIcon(whiteKing));
        }
    }

    private void putOnBlackPieces(boolean player) {
        if (player) {
            for (int i = 0; i < 8; ++i) {
                tiles[6][i].setIcon(new ImageIcon(blackPawn));
            }
            tiles[7][0].setIcon(new ImageIcon(blackRook));
            tiles[7][7].setIcon(new ImageIcon(blackRook));
            tiles[7][1].setIcon(new ImageIcon(blackKnight));
            tiles[7][6].setIcon(new ImageIcon(blackKnight));
            tiles[7][2].setIcon(new ImageIcon(blackBishop));
            tiles[7][5].setIcon(new ImageIcon(blackBishop));
            tiles[7][3].setIcon(new ImageIcon(blackQueen));
            tiles[7][4].setIcon(new ImageIcon(blackKing));
        } else {
            for (int i = 0; i < 8; ++i) {
                tiles[1][i].setIcon(new ImageIcon(blackPawn));
            }
            tiles[0][0].setIcon(new ImageIcon(blackRook));
            tiles[0][7].setIcon(new ImageIcon(blackRook));
            tiles[0][1].setIcon(new ImageIcon(blackKnight));
            tiles[0][6].setIcon(new ImageIcon(blackKnight));
            tiles[0][2].setIcon(new ImageIcon(blackBishop));
            tiles[0][5].setIcon(new ImageIcon(blackBishop));
            tiles[0][3].setIcon(new ImageIcon(blackQueen));
            tiles[0][4].setIcon(new ImageIcon(blackKing));
        }
    }
}
