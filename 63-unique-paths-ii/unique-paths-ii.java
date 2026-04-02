class Solution {
    public int uniquePathsWithObstacles(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] arr = new int[m][n];

        if(mat[0][0] != 1){
            arr[0][0] = 1;
        }

        if(mat[0][0] == 1){
            return 0;
        }

        boolean hor = false;

        for(int i=1; i<n; i++){
            if(mat[0][i] == 1){
                hor = true;
            }

            if(hor){
                arr[0][i] = 0;
            }
            else{
                arr[0][i] = 1;
            }

        }

        boolean ver = false;

        for(int i=1; i<m; i++){
            if(mat[i][0] == 1){
                ver = true;
            }

            if(ver){
                arr[i][0] = 0;
            }
            else{
                arr[i][0] = 1;
            }

        }

        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){

                if(mat[i][j] == 1){
                    arr[i][j] = 0;
                }
                else if(mat[i][j] == 0){
                    arr[i][j] = arr[i-1][j] + arr[i][j-1];
                }

            }
        }

        return arr[m-1][n-1];

        
    }
}