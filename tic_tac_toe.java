import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class TicTacToeGUI extends JFrame {
    private JButton[][] buttons;
    private char currentPlayer;
    private boolean gameWon;

    public TicTacToeGUI() {
        currentPlayer = 'X';
        gameWon = false;
        buttons = new JButton[3][3];

        setTitle("Tic-Tac-Toe");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 3));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton(" ");
                buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 60));
                buttons[i][j].setFocusPainted(false);
                buttons[i][j].addActionListener(new ButtonClickListener(i, j));
                add(buttons[i][j]);
            }
        }
        setVisible(true);
    }
    private class ButtonClickListener implements ActionListener {
        private int row, col;

        public ButtonClickListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (buttons[row][col].getText().equals(" ") && !gameWon) {
                buttons[row][col].setText(String.valueOf(currentPlayer));
                if (checkWin()) {
                    gameWon = true;
                    JOptionPane.showMessageDialog(TicTacToeGUI.this, "Player " + currentPlayer + " wins!");
                } else {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            }
        }
    }

    private boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            if ((buttons[i][0].getText().charAt(0) == currentPlayer && buttons[i][1].getText().charAt(0) == currentPlayer 
            && buttons[i][2].getText().charAt(0) == currentPlayer) ||
                (buttons[0][i].getText().charAt(0) == currentPlayer && buttons[1][i].getText().charAt(0) == currentPlayer 
                && buttons[2][i].getText().charAt(0) == currentPlayer)) {
                return true;
            }
        }
        if ((buttons[0][0].getText().charAt(0) == currentPlayer && buttons[1][1].getText().charAt(0) == currentPlayer 
        && buttons[2][2].getText().charAt(0) == currentPlayer) ||
            (buttons[0][2].getText().charAt(0) == currentPlayer && buttons[1][1].getText().charAt(0) == currentPlayer 
            && buttons[2][0].getText().charAt(0) == currentPlayer)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        new TicTacToeGUI();
    }
}
