import java.awt.*;
import javax.swing.*;

class NumberSelector extends JPanel {

    private JButton selected = null;
    private int errors = 0;

    public NumberSelector() {
        setLayout(new GridLayout(1, 9));

        for (int i = 1; i <= 9; i++) {
            JButton button = new JButton(String.valueOf(i));
            button.setFont(new Font("Arial", Font.BOLD, 20));
            button.setBackground(Color.WHITE);
            button.setFocusable(false);

            button.addActionListener(e -> {
                if (selected != null) {
                    selected.setBackground(Color.WHITE);
                }
                selected = button;
                selected.setBackground(Color.LIGHT_GRAY);
            });

            add(button);
        }
    }

    public JButton getSelected() {
        return selected;
    }

    public void incrementErrors() {
        errors++;
    }

    public int getErrors() {
        return errors;
    }
}
