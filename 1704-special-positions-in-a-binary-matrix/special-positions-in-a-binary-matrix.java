class Solution {
    public int numSpecial(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[] arr1 = new int[n];

        for(int i=0; i<n; i++){
            int count = 0;
            for(int j=0; j<m; j++){
                if(mat[i][j] == 1){
                    count++;
                }

            }

            arr1[i] = count;

        }

        int[] arr2 = new int[m];

        for(int i=0; i<m; i++){
            int count = 0;
            for(int j=0; j<n; j++){
                if(mat[j][i] == 1){
                    count++;
                }

            }

            arr2[i] = count;

        }

        int max = 0;

        for(int i=0; i<m; i++){
            
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(mat[i][j] == 1 && arr1[i] == 1 && arr2[j] == 1){
                    max++;
                }
            } 

        }

        return max;




        
    }
}
