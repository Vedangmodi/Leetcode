class Solution {
    int n;
    int m;

    int[][] direction = {{0,1}, {0, -1}, {1, 0}, {-1, 0}};

    public long dfs(int[][] grid, int i, int j){
        long sum = grid[i][j];
        grid[i][j] = 0;

        for(int[] dir : direction){
            int x = i + dir[0];
            int y = j + dir[1];

            if(x >= 0 && x < m && y >= 0 && y < n && grid[x][y] > 0){
                sum += dfs(grid, x, y);

            }
        }

        return sum;
    }

    public int countIslands(int[][] grid, int k) {

        m = grid.length;
        n = grid[0].length;

        int count = 0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] > 0){
                    long sum = dfs(grid, i, j);
                    if(sum % k == 0){
                        count++;
                    }
                }
            }
        }

        return count;
        
    }

    
}