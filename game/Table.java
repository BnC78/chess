package game;

import javax.swing.JPanel;

import misc.ChooseAction;
import moves.Moves;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import static moves.Moves.initializeMoves;

public class Table extends JPanel {
    
    private static Board board;
    private static Cell[][] cells;

    public Table() {
        board = new Board(true);
        cells = new Cell[8][8];
        refreshTable();
    }

    public void refreshTable() {
        this.removeAll();
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                Color bg = ((i + j) % 2 == 0) ? Color.WHITE : Color.DARK_GRAY;
                Cell cell = new Cell(i, j, board.getTile(i, j), bg);
                cells[i][j] = cell;
                if (!board.isEmptyTile(i, j)) {
                    cell.setIcon(board.getTile(i, j).getPiece().getIcon());
                }
                cell.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Cell cell = (Cell) e.getSource();
                        Tile tile = cell.getTile();
                        ChooseAction chooseAction = board.validateChoose(tile);
                        System.out.println(chooseAction);
                        Moves moves = null;
                        switch (chooseAction) {
                            case CHOOSE:
                                cell.choose();
                                moves = initializeMoves(board, cells, cell);
                                moves.showPossibleMoves();
                                break;
                            case UNCHOOSE:
                                refreshBackground();
                                cell.unchoose();
                                break;
                            case SWAP:
                                refreshBackground();
                                cell.choose();
                                moves = initializeMoves(board, cells, cell);
                                moves.showPossibleMoves();
                                break;
                            case MOVE:
                                break;
                            case INVALID:
                                refreshBackground();
                                break;
                        }
                    }
                });
                this.add(cell);
            }
        }
        this.setLayout(new GridLayout(8, 8));
        this.setVisible(true);
    }

    private void refreshBackground() {
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                cells[i][j].setBackgroundToDefault();
            }
        }
    }
}
