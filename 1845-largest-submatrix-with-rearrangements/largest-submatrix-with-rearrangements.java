class Solution {
    public int largestSubmatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int max = 0;

        for(int i=1; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] == 0){
                    continue;
                }
                else if(mat[i][j] != 0){
                    if(mat[i-1][j] == 0){
                        mat[i][j] = 1;
                    }
                    else if(mat[i-1][j] != 0){
                        mat[i][j] = mat[i-1][j] + 1;
                    }
                }


            }
        }

        for(int i=0; i<m; i++){
            int[] arr = mat[i];

            Arrays.sort(arr);
            int col= 1;

            for(int j=arr.length - 1; j>=0; j--){
                max = Math.max(max, arr[j] * col);
                col++;

            }
        }

        return max;
        
    }
}

// 0 0 1
// 1 1 2
// 2 0 3

// 1 0 0 - 1
// 2 1 1 - 3
// 3 2 0 - 4

// count -  2 1 3
//    |
//     1   [[0,0,1],
//     3   [1,1,1],
//     2   [1,0,1]]
