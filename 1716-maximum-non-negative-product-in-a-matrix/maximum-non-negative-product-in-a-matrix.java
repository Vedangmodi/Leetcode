class Solution {
    Pair<Long, Long>[][] pair;

    final int mod = 1_000_000_007;

    int m, n;

    public Pair<Long, Long> solve(int i, int j, int[][]grid){

        if(m == i + 1 && n == j + 1){
            return new Pair<>((long) grid[i][j], (long) grid[i][j]);
        }

        long maxVal = Long.MIN_VALUE;
        long minVal = Long.MAX_VALUE;

        if(pair[i][j] != null){
            return pair[i][j];
        }

        if(i + 1 < m){
            Pair<Long, Long> down = solve(i + 1, j, grid);
            maxVal = Math.max(maxVal, Math.max(grid[i][j] * down.getKey() , grid[i][j] * down.getValue()));
            minVal = Math.min(minVal, Math.min(grid[i][j] * down.getKey() , grid[i][j] * down.getValue()));
        }

        if(j + 1 < n){
            Pair<Long, Long> right = solve(i, j+1, grid);
            maxVal = Math.max(maxVal, Math.max(grid[i][j] * right.getKey() , grid[i][j] * right.getValue()));
            minVal = Math.min(minVal, Math.min(grid[i][j] * right.getKey() , grid[i][j] * right.getValue()));
        }

        pair[i][j] = new Pair<>(maxVal, minVal);

        return pair[i][j];

    }


    public int maxProductPath(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        pair = new Pair[m][n];

        Pair<Long, Long> res = solve(0, 0, grid);

        if(res.getKey() < 0){
            return -1;
        }
        else{
            return (int) (res.getKey() % mod);
        }



    }
}