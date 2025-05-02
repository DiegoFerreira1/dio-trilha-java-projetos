import javax.swing.*;
import java.awt.*;

public class SudokuGame {

    public static void main(String[] args) {

        String[] puzzle = {
            "--74916-5",
            "2---6-3-9",
            "-----7-1-",
            "-586----4",
            "--3----9-",
            "--62--187",
            "9-4-7---2",
            "67-83----",
            "81--45---"
        };

        String[] solution = {
            "387491625",
            "241568379",
            "569327418",
            "758619234",
            "123784596",
            "496253187",
            "934176852",
            "675832941",
            "812945763"
        };

        JFrame frame = new JFrame("Sudoku");
        frame.setSize(600, 650);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        JLabel textLabel = new JLabel("Sudoku: 0", JLabel.CENTER);
        textLabel.setFont(new Font("Arial", Font.BOLD, 30));
        frame.add(textLabel, BorderLayout.NORTH);

        NumberSelector selector = new NumberSelector();
        SudokuBoard board = new SudokuBoard(puzzle, solution, textLabel, selector);

        frame.add(board, BorderLayout.CENTER);
        frame.add(selector, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    
}
