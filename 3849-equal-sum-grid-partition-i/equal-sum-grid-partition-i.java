class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        
        if(ver(grid) || hor(grid)){
            return true;
        }

        return false;
        
        
        
    }

    public boolean ver(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;

        // int[][] mat = new int[m][n];

        long[] sumArray = new long[n];


        for(int i=0; i<n; i++){
            long sum = 0;

            for(int j=0; j<m; j++){
                sum = sum + grid[j][i];
            }

            sumArray[i] = sum;
        }

        long[] rightSum = new long[n];
        long[] leftSum = new long[n];

        leftSum[0] = sumArray[0];

        for(int i = 1; i<sumArray.length; i++){
            leftSum[i] = leftSum[i - 1] + sumArray[i];

        }

        rightSum[n - 1] = sumArray[n - 1];
        for(int i = n - 2; i >= 0; i--){
            rightSum[i] = rightSum[i + 1] + sumArray[i];
        }

        for(int i=0; i<n - 1; i++){
            if(leftSum[i] == rightSum[i + 1]){
                return true;
            }
        }

        return false;

    }

    // ----------------------------------------
    // ----------------------------------------


    public boolean hor(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;

        long[][] mat = new long[m][n];
        
        for(int i=0; i<m; i++){
            long sum = 0;

            for(int j=0; j<n; j++){
                sum += grid[i][j];

                mat[i][j] = sum;
            }
        }

        long[] downSum= new long[m];

        long s = 0;

        for(int i=0; i<m; i++){
            s += mat[i][n - 1];
            downSum[i] = s;
            
        }

        long c = 0;

        long[] upSum = new long[m];

        for(int i=m-1; i>=0; i--){
            c += mat[i][n-1];
            upSum[i] = c;
            
        }

        for(int i=0; i<m- 1; i++){
            if(downSum[i] == upSum[i + 1]){
                return true;
            }
        }

        return false;

    }   
}