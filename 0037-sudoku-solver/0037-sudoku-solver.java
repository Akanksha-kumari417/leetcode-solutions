class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    private boolean solve(char[][] board) {

        // Traverse every cell of the Sudoku board
        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board[0].length; j++) {

                // Check whether the current cell is empty
                if (board[i][j] == '.') {

                    // Try placing digits from 1 to 9
                    for (char c = '1'; c <= '9'; c++) {

                        // Check whether placing c is valid
                        if (isValid(board, i, j, c)) {

                            // Place the digit
                            board[i][j] = c;

                            // Recursively solve the remaining board
                            if (solve(board)) {
                                return true;
                            } else {

                                // Backtrack: undo the placement
                                board[i][j] = '.';
                            }
                        }
                    }

                    // No digit from 1 to 9 worked
                    return false;
                }
            }
        }

        // All cells have been successfully filled
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char c) {

        for (int i = 0; i < 9; i++) {

            // Check the column
            if (board[i][col] == c) {
                return false;
            }

            // Check the row
            if (board[row][i] == c) {
                return false;
            }

            // Check the 3x3 subgrid
            if (board[3 * (row / 3) + i / 3]
                    [3 * (col / 3) + i % 3] == c) {
                return false;
            }
        }

        return true;
    }

}