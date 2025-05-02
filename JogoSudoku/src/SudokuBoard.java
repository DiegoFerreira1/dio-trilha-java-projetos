import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

class SudokuBoard extends JPanel {

    Tile[][] tiles = new Tile[9][9];

    public SudokuBoard(String[] puzzle, String[] solution, JLabel textLabel, NumberSelector selector) {
        setLayout(new GridLayout(9, 9));

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                Tile tile = new Tile(r, c);
                tiles[r][c] = tile;

                char tileChar = puzzle[r].charAt(c);
                if (tileChar != '-') {
                    tile.setText(String.valueOf(tileChar));
                    tile.setFont(new Font("Arial", Font.BOLD, 20));
                    tile.setBackground(Color.LIGHT_GRAY);
                    tile.setEnabled(false);
                } else {
                    tile.setFont(new Font("Arial", Font.PLAIN, 20));
                    tile.setBackground(Color.WHITE);

                    tile.addActionListener(e -> {
                        if (selector.getSelected() != null) {
                            String selectedValue = selector.getSelected().getText();
                            String correct = String.valueOf(solution[tile.r].charAt(tile.c));
                            if (selectedValue.equals(correct)) {
                                tile.setText(selectedValue);
                            } else {
                                selector.incrementErrors();
                                textLabel.setText("Sudoku: " + selector.getErrors());
                            }
                        }
                    });
                }

                
                tile.setBorder(getTileBorder(r, c));
                add(tile);
            }
        }
    }

    private Border getTileBorder(int r, int c) {
        int bottom = (r == 2 || r == 5) ? 5 : 1;
        int right = (c == 2 || c == 5) ? 5 : 1;
        return BorderFactory.createMatteBorder(1, 1, bottom, right, Color.BLACK);
    }
}
