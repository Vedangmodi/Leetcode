class Solution {
    public char[][] rotateTheBox(char[][] mat) { 

        int m = mat.length;
        int n = mat[0].length;

        char[][] grid = new char[n][m]; 


        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                grid[j][i] = mat[i][j];
                
            }
        }
        int a = 0;
        int b = m - 1;

        while(a < b){
            for(int c = 0;c < n; c++){
                char temp = grid[c][a];
                grid[c][a] = grid[c][b];
                grid[c][b] = temp;

            }

            a++;
            b--;
        }

        for (int j = 0; j < m; j++) {
            int Bottom = n - 1;
            for (int i = n - 1; i >= 0; i--) {
                if (grid[i][j] == '*') {
                    Bottom = i - 1;
                    continue;
                }

                if (grid[i][j] == '#') {
                    grid[i][j] = '.';
                    grid[Bottom][j] = '#';
                    Bottom--;
                }
            }
        }

        return grid;

        
    }
}