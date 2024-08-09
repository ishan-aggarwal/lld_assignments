package others;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MinesweeperGUI extends JFrame {
    private Grid grid; // The game grid
    private final JButton[][] buttons; // The buttons representing each cell
    private boolean gameOver;

    public MinesweeperGUI() {
        grid = new Grid(); // Create a new Grid with default settings
        buttons = new JButton[grid.getNumRows()][grid.getNumColumns()];
        gameOver = false;
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Minesweeper");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(grid.getNumRows(), grid.getNumColumns()));

        // Initialize the buttons and add them to the frame
        for (int row = 0; row < grid.getNumRows(); row++) {
            for (int col = 0; col < grid.getNumColumns(); col++) {
                buttons[row][col] = new JButton();
                buttons[row][col].setFont(new Font("Arial", Font.BOLD, 20));
                buttons[row][col].setFocusPainted(false);
                buttons[row][col].addActionListener(new CellActionListener(row, col));
                add(buttons[row][col]);
            }
        }

        setVisible(true);
    }

    private class CellActionListener implements ActionListener {
        private final int row;
        private final int col;

        public CellActionListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (gameOver) {
                return; // Ignore clicks if the game is over
            }

            if (grid.isBombAtLocation(row, col)) {
                revealGrid();
                gameOver = true;
                showGameOverDialog(false);
            } else {
                revealCell(row, col);
                if (checkWin()) {
                    gameOver = true;
                    showGameOverDialog(true);
                }
            }
        }
    }

    private void revealGrid() {
        for (int row = 0; row < grid.getNumRows(); row++) {
            for (int col = 0; col < grid.getNumColumns(); col++) {
                if (grid.isBombAtLocation(row, col)) {
                    buttons[row][col].setText("B");
                    buttons[row][col].setBackground(Color.RED);
                } else {
                    buttons[row][col].setText(String.valueOf(grid.getCountAtLocation(row, col)));
                    buttons[row][col].setEnabled(false);
                }
            }
        }
    }

    private void revealCell(int row, int col) {
        buttons[row][col].setText(String.valueOf(grid.getCountAtLocation(row, col)));
        buttons[row][col].setEnabled(false);
    }

    private boolean checkWin() {
        for (int row = 0; row < grid.getNumRows(); row++) {
            for (int col = 0; col < grid.getNumColumns(); col++) {
                if (!grid.isBombAtLocation(row, col) && buttons[row][col].isEnabled()) {
                    return false; // Not all non-bomb cells have been revealed
                }
            }
        }
        return true;
    }

    private void showGameOverDialog(boolean won) {
        String message = won ? "Congratulations! You've won the game!" : "Game Over! You hit a bomb.";
        int option = JOptionPane.showConfirmDialog(this, message + "\nDo you want to play again?", "Game Over", JOptionPane.YES_NO_OPTION);

        if (option == JOptionPane.YES_OPTION) {
            resetGame();
        } else {
            System.exit(0); // Close the application
        }
    }

    private void resetGame() {
        grid = new Grid(); // Create a new grid
        gameOver = false;
        for (int row = 0; row < grid.getNumRows(); row++) {
            for (int col = 0; col < grid.getNumColumns(); col++) {
                buttons[row][col].setText("");
                buttons[row][col].setEnabled(true);
                buttons[row][col].setBackground(null);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MinesweeperGUI::new);
    }
}
