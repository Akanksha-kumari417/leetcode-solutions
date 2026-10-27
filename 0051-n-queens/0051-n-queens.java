class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();

        char[][] board = new char[n][n];

        // Initialize every cell with '.'
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        solve(0, board, result);

        return result;
    }

    private void solve(int row, char[][] board,
                       List<List<String>> result) {

        if (row == board.length) {
            List<String> currentBoard = new ArrayList<>();

            for (int i = 0; i < board.length; i++) {
                currentBoard.add(new String(board[i]));
            }

            result.add(currentBoard);
            return;
        }

        for (int col = 0; col < board.length; col++) {

            if (isSafe(row, col, board)) {
                board[row][col] = 'Q';

                solve(row + 1, board, result);

                board[row][col] = '.';
            }
        }
    }

    private boolean isSafe(int row, int col, char[][] board) {

        // Check column
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Check upper-left diagonal
        int i = row - 1;
        int j = col - 1;

        while (i >= 0 && j >= 0) {
            if (board[i][j] == 'Q') {
                return false;
            }

            i--;
            j--;
        }

        // Check upper-right diagonal
        i = row - 1;
        j = col + 1;

        while (i >= 0 && j < board.length) {
            if (board[i][j] == 'Q') {
                return false;
            }

            i--;
            j++;
        }

        return true;
    }
}