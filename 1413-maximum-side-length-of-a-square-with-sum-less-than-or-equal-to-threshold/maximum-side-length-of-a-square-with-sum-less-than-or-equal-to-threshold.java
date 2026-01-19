class Solution {
    public int maxSideLength(int[][] mat, int t) {

        int m = mat.length;
        int n = mat[0].length;

        int[][] prefix = new int[m][n];
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                prefix[i][j] += mat[i][j];
                if(i > 0){
                    prefix[i][j] += prefix[i - 1][j];

                }

                if(j > 0){
                    prefix[i][j] += prefix[i][j - 1];
                }

                if(i>0 && j>0){
                    prefix[i][j] -= prefix[i-1][j-1];
                }
                 
            }
        }

        int max = 0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){

                for(int k=0; k<Math.min(m-i, n-j); k++){
                    int r = i + k;
                    int c = j + k;

                    int sum = prefix[r][c];

                    if(i > 0){
                        sum -= prefix[i-1][c];
                        
                    }

                    if(j > 0){
                        sum -= prefix[r][j-1];
                    }

                    if(i > 0 && j > 0){
                        sum = sum + prefix[i - 1][j - 1];
                    }

                    if(sum <= t){
                        max = Math.max(max, k + 1);
                    }
                    else{
                        break;
                    }

                }

            }
        }

        return max;



        

        
    }
}