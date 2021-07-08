package game;

import misc.Start;

public class Board {

    public Tile[][] tiles;

    public Board(boolean white) {
        this.createBoard(white);
    }

    private void createBoard(boolean white) {
        this.tiles = (white ? Start.asWhite() : Start.asBlack());
    }

    public boolean isEmptyTile(int row, int column) {
        return tiles[row][column].isEmpty();
    }

    public Tile getTile(int row, int column) {
        return tiles[row][column];
    }
}
