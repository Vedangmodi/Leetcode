class Solution {
    int m;
    int n;
    int[][][] dp;

    public int maxPathScore(int[][] mat, int k) {
        m = mat.length;
        n = mat[0].length;

        dp = new int[m][n][k+1];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                for(int p=0; p<=k; p++){
                    dp[i][j][p] = -1;

                }
            }
        }

        int ans = solve(mat,k, 0, 0, 0);

        return ans == Integer.MIN_VALUE ? -1 : ans;
        
    }

    public int solve(int[][] mat, int k, int i, int j, int cost){
 
        if(i >= m || j >= n){
            return Integer.MIN_VALUE;
        }

        int newCost = cost + (mat[i][j] != 0 ? 1 : 0);

        if(newCost > k){
            return Integer.MIN_VALUE;
        }

        if(i == m - 1 && j == n - 1){
            return mat[i][j];
        }

        if(dp[i][j][cost] != -1){
            return dp[i][j][cost];
        }

        int right = solve(mat,k, i, j + 1, newCost);
        int down = solve(mat,k, i + 1, j, newCost);

        int max = Math.max(down, right);

        if(max == Integer.MIN_VALUE ){
            return dp[i][j][cost] = Integer.MIN_VALUE;
        }

        return dp[i][j][cost] = max + mat[i][j];

    }
}