import java.awt.*;
import java.awt.event.*;

public class TicTacToe extends Frame implements ActionListener {
    Button[] buttons = new Button[9];
    char currentPlayer = 'X';
    boolean gameOver = false;

    public TicTacToe() {
        setTitle("🎮 Colorful Tic-Tac-Toe");
        setSize(420, 420);
        setLayout(new GridLayout(3, 3, 5, 5));
        Font font = new Font("Arial", Font.BOLD, 50);
        setBackground(Color.DARK_GRAY);

        for (int i = 0; i < 9; i++) {
            buttons[i] = new Button("");
            buttons[i].setFont(font);
            buttons[i].setBackground(Color.LIGHT_GRAY);
            buttons[i].setForeground(Color.BLACK);
            buttons[i].addActionListener(this);
            add(buttons[i]);
        }

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Button clicked = (Button) e.getSource();

        if (clicked.getLabel().equals("") && !gameOver) {
            clicked.setLabel(String.valueOf(currentPlayer));
            clicked.setForeground(currentPlayer == 'X' ? Color.RED : Color.BLUE);

            if (checkWin()) {
                highlightWinningCombo();
                showResult("🎉 Player " + currentPlayer + " wins!");
                gameOver = true;
            } else if (isDraw()) {
                showResult("😐 It's a draw!");
                gameOver = true;
            } else {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }
    }

    private boolean checkWin() {
        String[][] combos = new String[3][3];
        for (int i = 0; i < 9; i++) {
            combos[i / 3][i % 3] = buttons[i].getLabel();
        }

        // Rows, Columns, Diagonals
        for (int i = 0; i < 3; i++) {
            if (match(i * 3, i * 3 + 1, i * 3 + 2)) return true; // row
            if (match(i, i + 3, i + 6)) return true; // col
        }
        if (match(0, 4, 8)) return true; // diag
        if (match(2, 4, 6)) return true; // anti-diag

        return false;
    }

    private boolean match(int a, int b, int c) {
        String s1 = buttons[a].getLabel();
        String s2 = buttons[b].getLabel();
        String s3 = buttons[c].getLabel();
        return !s1.equals("") && s1.equals(s2) && s2.equals(s3);
    }

    private void highlightWinningCombo() {
        int[][] wins = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // Rows
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // Columns
            {0, 4, 8}, {2, 4, 6}             // Diagonals
        };

        for (int[] combo : wins) {
            int a = combo[0], b = combo[1], c = combo[2];
            if (match(a, b, c)) {
                buttons[a].setBackground(Color.GREEN);
                buttons[b].setBackground(Color.GREEN);
                buttons[c].setBackground(Color.GREEN);
                break;
            }
        }
    }

    private boolean isDraw() {
        for (Button b : buttons) {
            if (b.getLabel().equals("")) return false;
        }
        return true;
    }

    private void showResult(String message) {
        Dialog d = new Dialog(this, "Game Over", true);
        d.setLayout(new FlowLayout());
        d.setSize(280, 100);
        d.setBackground(Color.WHITE);
        d.add(new Label(message));
        Button ok = new Button("Play Again 🔁");
        ok.addActionListener(e -> {
            d.setVisible(false);
            d.dispose();
            dispose();                      // Close current frame
            new TicTacToe();       // Start new game window
        });
        d.add(ok);
        d.setVisible(true);
    }

    public static void main(String[] args) {
        new TicTacToe();
    }
}
