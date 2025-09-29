class Solution {
    public int minScoreTriangulation(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        return solve(arr, 0, n - 1, dp);
    }

    public int solve(int[] arr, int x, int y, int[][] dp) {
        if (y - x + 1 < 3) {
            return 0;
        }

        if (dp[x][y] != 0) {   
            return dp[x][y];
        }

        int res = Integer.MAX_VALUE;

        for (int i = x + 1; i < y; i++) {
            int wt = (arr[i] * arr[x] * arr[y]) 
                   + solve(arr, x, i, dp) 
                   + solve(arr, i, y, dp);
            res = Math.min(res, wt);
        }

        dp[x][y] = res;   
        return res;
    }
}
