package game;

import javax.swing.JPanel;

import misc.ChooseAction;
import moves.Moves;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;

import static moves.Moves.initializeMoves;

public class Table extends JPanel {
    
    private static Board board;
    private static Cell[][] cells;
    private static Cell chosenCell;

    public Table() {
        board = new Board(true);
        cells = new Cell[8][8];
        createTable();
        addCellsToTable();
    }

    public void createTable() {
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                Color bg = ((i + j) % 2 == 0) ? Color.WHITE : Color.DARK_GRAY;
                Cell cell = new Cell(i, j, bg);
                if (!board.isEmptyTile(i, j)) {
                    cell.setIcon(board.getTile(i, j).getPiece().getIcon());
                }
                cells[i][j] = cell;
                cell.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Cell cell = (Cell) e.getSource();
                        ChooseAction chooseAction = board.validateChoose(cell.getRow(), cell.getColumn(), cell.getBackground());
                        System.out.println(chooseAction + " " + board.getTile(cell.getRow(), cell.getColumn()).getPiece());
                        Moves moves = null;
                        refreshBackground();
                        switch (chooseAction) {
                            case CHOOSE:
                                cell.choose();
                                chosenCell = cell;
                                moves = initializeMoves(board, cells, cell);
                                moves.showPossibleMoves();
                                break;
                            case UNCHOOSE:
                                cell.unchoose();
                                chosenCell = null;
                                break;
                            case SWAP:
                                cell.choose();
                                chosenCell = cell;
                                moves = initializeMoves(board, cells, cell);
                                moves.showPossibleMoves();
                                break;
                            case MOVE:
                                cell.setIcon(chosenCell.getIcon());
                                chosenCell.setIcon(null);
                                chosenCell = null;
                                refreshTable();
                                break;
                            case INVALID:
                                cell.unchoose();
                                chosenCell = null;
                                break;
                        }
                    }
                });
            }
        }
        this.setLayout(new GridLayout(8, 8));
        this.setVisible(true);
    }

    private void refreshTable() {
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                if (!board.isEmptyTile(i, j)) {
                    cells[i][j].setIcon(board.getTile(i, j).getPiece().getIcon());
                } else {
                    cells[i][j].setIcon(null);
                }
            }
        }
    }

    private void addCellsToTable() {
        Arrays.stream(cells)
              .flatMap(row -> Arrays.stream(row))
              .forEach(cell -> this.add(cell));
    }

    private void refreshBackground() {
        Arrays.stream(cells)
              .flatMap(row -> Arrays.stream(row))
              .forEach(cell -> cell.setBackgroundToDefault());
    }
}
