class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] arr = new int[m*n];

        int k = 0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                arr[k] = grid[i][j] % 12345;
                k++;

            }
        }

        // arr =  1, 2, 3, 4


        int[] nums = new int[m*n];
        nums[0] = 1;

        for(int i=1; i<arr.length; i++){
            nums[i] = (nums[i - 1] * arr[i - 1]) % 12345;

        }

        // 1 1 2 6

        int right = 1;

        for(int i=arr.length-1; i>=0; i--){
            nums[i] = (right * nums[i]) % 12345;

            right = (right * arr[i]) % 12345;

        }

        int l = 0;


        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                grid[i][j] = nums[l] % 12345 ;
                l++;
            }
        }

        return grid;
        
    }
}