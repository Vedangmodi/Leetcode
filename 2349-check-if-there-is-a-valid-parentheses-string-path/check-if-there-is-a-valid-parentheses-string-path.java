class Solution {
    int m;
    int n;

    int[][][] memo;

    public boolean hasValidPath(char[][] grid) {
        m = grid.length;
        n = grid[0].length;

        memo = new int[m][n][201];

        if ((m + n - 1) % 2 == 1){
            return false;
        }
            

        if(grid[0][0] == ')' || grid[m - 1][n - 1] == '('){
            return false;
        }

        for(int[][] row : memo){
            for(int[] col : row){
                Arrays.fill(col, -1);
            }
        }

        return solve(0, 0, 0, grid);

        


        
    }

    public boolean solve(int i, int j, int count, char[][] grid){
        count += (grid[i][j] == '(') ? 1 : -1;

        if(count < 0){
            return false;
        }

        if(memo[i][j][count] != -1){
            return memo[i][j][count] == 1;

        }

        if(i == m - 1 && j == n - 1){
            return count == 0;
        }

        // right
        if(j + 1 < n){
            if(solve(i, j + 1, count, grid)){
                memo[i][j][count] = 1;
                return true;
            }

        }

        // down
        if(i + 1 < m){
            if(solve(i + 1, j, count, grid)){
                memo[i][j][count] = 1;
                return true;
            }

        }

        memo[i][j][count] = 0;
        return false;

        

    }
}