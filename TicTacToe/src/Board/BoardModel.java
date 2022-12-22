package Board;
import java.util.Arrays;

public class BoardModel {
    // Constants for the dimensions of the board
    public static final int NUM_ROWS = 3;
    public static final int NUM_COLS = 3;

    // Constants for the different states that a cell can be in
    public static final char X = 'X';
    public static final char O = 'O';
    public static final char BLANK = ' ';

    // 2D array to represent the state of each cell on the board
    private char[][] cells;


    private char turn;

    // Constructor to initialize the board to all blank cells
    public BoardModel() {
        cells = new char[NUM_ROWS][NUM_COLS];
        for (char[] row : cells) {
            Arrays.fill(row, BLANK);
        }
    }

    // Method to set the state of a cell at a given row and column
    public void setCell(int row, int col, char state) {
        cells[row][col] = state;
    }

    // Method to get the state of a cell at a given row and column
    public char getCell(int row, int col) {
        return cells[row][col];
    }
    public char getTurn() {
        return turn;
    }

    // Method to check if the board is full (no more moves left)
    public boolean isFull() {
        for (char[] row : cells) {
            for (char cell : row) {
                if (cell == BLANK) {
                    return false;
                }
            }
        }
        return true;
    }

    public int getRow(Object source) {
        for (int row = 0; row < NUM_ROWS; row++) {
            for (int col = 0; col < NUM_COLS; col++) {
                if (buttons[row][col] == source) {
                    return row;
                }
            }
        }
        return -1;
    }
    

    // Method to check if the game has been won by either player
    public char checkWin() {
        // Check rows
        for (char[] row : cells) {
            if (row[0] != BLANK && row[0] == row[1] && row[1] == row[2]) {
                return row[0];
            }
        }

        // Check columns
        for (int col = 0; col < NUM_COLS; col++) {
            if (cells[0][col] != BLANK && cells[0][col] == cells[1][col] && cells[1][col] == cells[2][col]) {
                return cells[0][col];
            }
        }

        // Check diagonals
        if (cells[0][0] != BLANK && cells[0][0] == cells[1][1] && cells[1][1] == cells[2][2]) {
            return cells[0][0];
        }
        if (cells[0][2] != BLANK && cells[0][2] == cells[1][1] && cells[1][1] == cells[2][0]) {
            return cells[0][2];
        }

        // No winner
        return BLANK;
    }
}



