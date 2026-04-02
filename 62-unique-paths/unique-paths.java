class Solution {
    public int uniquePaths(int m, int n) {

        if(m == 1 && n ==1){
            return 1;
        }
        int[][] mat = new int[n][m];
        mat[0][0] = 0;

        for(int i=1; i<n; i++){
            mat[i][0] = 1;

        }

        for(int i=1; i<m; i++){
            mat[0][i] = 1;
        }

        for(int i=1; i<n; i++){
            for(int j=1; j<m; j++){
                mat[i][j] = mat[i-1][j] + mat[i][j-1];
            }

        }

        return mat[n-1][m-1];

        
        
    }
}