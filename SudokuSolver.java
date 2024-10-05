public class SudokuSolver {

    // Size of the Sudoku grid (9x9)
    private static final int GRID_SIZE = 9;

    public static void main(String[] args) {
        // Example unsolved Sudoku grid (0 represents empty cells)
        int[][] board = {
                {7, 0, 2, 0, 5, 0, 6, 0, 0},
                {0, 0, 0, 0, 0, 3, 0, 0, 0},
                {1, 0, 0, 0, 0, 9, 5, 0, 0},
                {8, 0, 0, 0, 0, 0, 0, 9, 0},
                {0, 4, 3, 0, 0, 0, 7, 5, 0},
                {0, 9, 0, 0, 0, 0, 0, 0, 8},
                {0, 0, 9, 7, 0, 0, 0, 0, 5},
                {0, 0, 0, 2, 0, 0, 0, 0, 0},
                {0, 0, 7, 0, 4, 0, 2, 0, 3}
        };

        if (solveSudoku(board)) {
            System.out.println("Sudoku solved successfully!");
            printBoard(board);
        } else {
            System.out.println("Unsolvable Sudoku puzzle.");
        }
    }

    // Sudoku solving method using backtracking
    private static boolean solveSudoku(int[][] board) {
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                // Look for empty cells (represented by 0)
                if (board[row][col] == 0) {
                    // Try all possible numbers (1 to 9)
                    for (int num = 1; num <= GRID_SIZE; num++) {
                        if (isValidPlacement(board, num, row, col)) {
                            board[row][col] = num;

                            // Recursively try to solve the rest of the board
                            if (solveSudoku(board)) {
                                return true;
                            } else {
                                // Backtrack if the placement didn't work
                                board[row][col] = 0;
                            }
                        }
                    }
                    return false; // If no valid number found, backtrack
                }
            }
        }
        return true; // All cells are filled
    }

    // Method to check if placing a number is valid
    private static boolean isValidPlacement(int[][] board, int num, int row, int col) {
        // Check the row
        for (int i = 0; i < GRID_SIZE; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }

        // Check the column
        for (int i = 0; i < GRID_SIZE; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }

        // Check the 3x3 sub-grid
        int boxRowStart = row - row % 3;
        int boxColStart = col - col % 3;
        for (int i = boxRowStart; i < boxRowStart + 3; i++) {
            for (int j = boxColStart; j < boxColStart + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    // Method to print the Sudoku board
    private static void printBoard(int[][] board) {
        for (int row = 0; row < GRID_SIZE; row++) {
            if (row % 3 == 0 && row != 0) {
                System.out.println("-----------"); // Print horizontal line after every 3 rows
            }
            for (int col = 0; col < GRID_SIZE; col++) {
                if (col % 3 == 0 && col != 0) {
                    System.out.print("|"); // Print vertical line after every 3 columns
                }
                System.out.print(board[row][col] == 0 ? "." : board[row][col]); // Print 0 as "."
            }
            System.out.println();
        }
    }
}
