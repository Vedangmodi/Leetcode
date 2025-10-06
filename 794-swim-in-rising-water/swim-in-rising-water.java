class Solution {
    int n;

    int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    boolean[][] visited;

    public boolean reachable(int[][] grid, int i, int j, int mid){
        if(i<0 || j<0 || i>=n || j>=n || visited[i][j] || grid[i][j] > mid){
            return false;
        }

        visited[i][j] = true;

        if (i == n - 1 && j == n - 1)
            return true;

        for (int[] arr : dir) {
            int newi = i + arr[0];
            int newj = j + arr[1];
            if (reachable(grid, newi, newj, mid))
             return true;
        }

        return false;

    } 

    public int swimInWater(int[][] grid) {
        n = grid.length;

        int l = grid[0][0];
        int r = n * n - 1;
        int result = 0;

        while(l <= r){
            int mid = l + (r-l)/2;
            visited = new boolean[n][n];

            if(reachable(grid, 0, 0, mid)){
                result = mid;
                r = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }
        return result;  
    }
}