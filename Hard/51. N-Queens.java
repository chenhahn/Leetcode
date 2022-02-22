class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result =  new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = '.';
            }
        }
        solveNQueens(result, board, 0);
        return result;
    }
    
    private void solveNQueens(List<List<String>> list, char[][] board, int row) {
        if (row == board.length) {
            addSolu(list, board);
            return;
        }
        for (int col = 0; col < board.length; col++) {
            board[row][col] = 'Q';
            if (isValid(board, row, col)) {
                solveNQueens(list, board, row + 1);
            }
            board[row][col] = '.';
         }
    }
    
    private boolean isValid(char[][] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 'Q' && (i + col == j + row || i + j == row + col || j == col))
                    return false;
            }
        }
        return true;
    }
    
    private void addSolu(List<List<String>> list, char[][] board) {
        List<String> lst = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            lst.add(s);
        }
        list.add(lst);
    }
}