class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int n = x + k - 1; 
        for(int i=x; i<x + k ; i++){

            int m = y;
            for(int j=y; j<y + k ; j++){

                int temp = grid[i][j];
                grid[i][j] = grid[n][m];
                grid[n][m] = temp;

                m++;

            }

            n--;

            if(i >= n ){
                break;
            }
        }

        return grid;
        
    }
}