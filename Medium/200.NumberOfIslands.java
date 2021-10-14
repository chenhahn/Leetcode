class Solution {
    public int numIslands(char[][] grid) {
        int count = 1;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == '1'){
                    check(i, j, grid); 
                    count++;
                }
            }
        }
        return count - 1;
    }
    public void check(int i, int j, char[][] grid){
        if(i >= 0 && i < grid.length && j >= 0 && j < grid[i].length && grid[i][j] == '1'){
            grid[i][j] = '2';  
        }else{
            return;
        }
        check(i + 1, j, grid);
        check(i, j - 1, grid);
        check(i - 1, j, grid);
        check(i, j + 1, grid);
    }
}