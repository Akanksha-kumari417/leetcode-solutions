class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    if(solve(board, word, i, j, 0)) return true;
                }
            }
        }
        return false;
    }
    private boolean solve(char[][]board, String word, int row, int col, int index){
        if(index == word.length()) return true;
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length) return false;
        if(board[row][col] == '#') return false;
        if(board[row][col] != word.charAt(index)) return false;
        char original = board[row][col];
        board[row][col] = '#';
        boolean found = solve(board, word, row-1, col, index+1)|| solve(board, word, row+1, col, index+1)|| solve(board, word, row, col-1, index+1)|| solve(board, word, row, col+1, index+1);
        board[row][col] = original;
        return found;
    }
}