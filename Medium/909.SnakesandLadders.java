class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int move = 0;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n * n];
        queue.offer(1);
        while (!queue.isEmpty()) {
            for (int size = queue.size(); size > 0; size--){
                int num = queue.poll();
                if (num == n * n) return move;
                for (int i = 1; i <= 6 && num + i <= n * n; i++) {
                    int value = getBoardValue(board, num + i);
                    int next = value > 0 ? value : num + i;
                    if (!visited[next - 1]) {
                       visited[next - 1] = true;
                        queue.offer(next);
                    }
                }
            }
            move++;
        }
        return -1;
    }
    
    private int getBoardValue(int[][] board, int num) {
        int n = board.length;
        int x = (num - 1) / n;
        int row = n - 1 - x;
        int col = x % 2 == 0 ? num - 1 - x * n : n - num + x * n;
        return board[row][col];
    }
}

// Time Complexity: O(n^2)
// Space Complexity: O(n^2)