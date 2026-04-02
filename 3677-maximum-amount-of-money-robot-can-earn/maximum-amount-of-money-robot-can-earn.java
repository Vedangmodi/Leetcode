class Solution {
    int m;
    int n;
    int[][][] dp ;

    public int maximumAmount(int[][] mat) {
        m = mat.length;
        n = mat[0].length;

        dp = new int[m][n][3];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<3; k++){
                    dp[i][j][k] = Integer.MIN_VALUE;
                }
            }
        }

        return solve(mat, 0, 0, 2);
        
    }

    public int solve(int[][] mat, int i, int j, int neu){
        if(i >= m || j >= n){
            return Integer.MIN_VALUE;
        }

        // base case

        if(i == m - 1 && j == n - 1){
            if(mat[i][j] < 0 && neu > 0){
                return 0;
            }

            return mat[i][j];
        }

        //memo

        if(dp[i][j][neu] != Integer.MIN_VALUE){
            return dp[i][j][neu];
        }

        int best = Integer.MIN_VALUE;

        //down

        int down = solve(mat, i + 1, j, neu);
        if(down != Integer.MIN_VALUE){
            best = Math.max(best, mat[i][j] + down);
        }

        // right

        int right = solve(mat, i, j+1, neu);
        if(right != Integer.MIN_VALUE){
            best = Math.max(best, mat[i][j] + right);
        }

        // skip -ve
        if(mat[i][j] < 0 && neu > 0){
            int downskip = solve(mat, i+1, j, neu - 1);
            int rightskip = solve(mat, i, j+1, neu -1);

            int maxskip = Math.max(downskip, rightskip);

            if(maxskip != Integer.MIN_VALUE){
                best = Math.max(best, maxskip);

            } 
        }
        return dp[i][j][neu] = best;
    }
}