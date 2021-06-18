package misc;

import java.awt.Image;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.io.File;
import java.io.IOException;

public enum Icons {
    
    WHITEPAWN("whitePawn.png"),     BLACKPAWN("blackPawn.png"),
    WHITEROOK("whiteRook.png"),     BLACKROOK("blackRook.png"),
    WHITEKNIGHT("whiteKnight.png"), BLACKKNIGHT("blackKnight.png"),
    WHITEBISHOP("whiteBishop.png"),  BLACKBISHOP("blackBishop.png"),
    WHITEKING("whiteKing.png"),     BLACKKING("blackKing.png"),
    WHITEQUEEN("whiteQueen.png"),   BLACKQUEEN("blackQueen.png");

    private ImageIcon icon;

    private Icons(String fileName) {
        try {
            icon = new ImageIcon(ImageIO.read(new File("chess/images/" + fileName)).getScaledInstance(80, 80, Image.SCALE_FAST));
        } catch (IOException ex) {
            System.err.println("Image import failed! Program will shut down");
            System.err.println(ex.getMessage());
            ex.printStackTrace();
            System.exit(1);
        }
    }

    public ImageIcon getIcon() {
        return icon;
    }
}
