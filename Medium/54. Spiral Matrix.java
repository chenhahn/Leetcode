class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<Integer>();
        
        if (matrix.length == 0 || matrix == null)
            return ans;
        
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        int m = matrix.length;
        int n = matrix[0].length;
        int r = 0, c = 0;
        int di = 0;
        boolean[][] seen = new boolean[m][n];
        
        for (int i = 0; i < m * n; i++) {
            ans.add(matrix[r][c]);
            seen[r][c] = true;
            int nextR = r + dr[di];
            int nextC = c + dc[di];
            
            if (0 <= nextR && nextR < m && 0 <= nextC && nextC < n && !seen[nextR][nextC]) {
                r = nextR;
                c = nextC;
            } else {
                di = (di + 1) % 4;
                r += dr[di];
                c += dc[di];
            }
        }
        
        return ans;
    }
}

// Time complexity: O(m * n)
// Space complexity: O(m * n)