class Solution {
    public boolean exist(char[][] board, String word) {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == word.charAt(0) && search(board, word, 0, r, c))
                    return true;
            }
        }
        return false;
    }
    
    private boolean search(char[][] board, String word, int index, int row, int column) {
        if (index >= word.length())
            return true;
        
        if (row < 0 || column < 0 || row >= board.length || column >= board[0].length || board[row][column] == '0' || board[row][column] != word.charAt(index))
            return false;
        
        char temp = board[row][column];
        board[row][column] = '0';
        
        if(search(board, word, index + 1, row + 1, column) || search(board, word, index + 1, row - 1, column) || search(board, word, index + 1, row, column + 1) || search(board, word, index + 1, row, column - 1))
            return true;
        
        board[row][column] = temp;
        return false;
    }
}

// Time complexity: O(M*N*4^L) -> M: board's row; N: board's column; L: length of the word
// Time complexity: O(L) -> maximum depth of recursion