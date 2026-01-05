class Solution {
    public long maxMatrixSum(int[][] mat) {

        long min = Long.MAX_VALUE;
        long sum = 0;
        int count = 0;


        for(int i=0; i<mat.length; i++){
            for(int j = 0; j<mat[0].length; j++){
                if(mat[i][j] < 0){
                    count++;
                }

                sum = sum + Math.abs(mat[i][j]);

                min = Math.min(min, Math.abs(mat[i][j]));

            }
        }

        if(count % 2 == 0){
            return sum;
        }
        else{
            return sum - min - min;
        }
        
    }
}