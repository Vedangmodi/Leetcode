class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int MOD = 1000000007;
        for(int i=0; i<queries.length; i++){
            int l = queries[i][0];
            int r = queries[i][1];
            int k = queries[i][2];
            int v = queries[i][3];

            int idx = l;

            while(idx <= r){
                nums[idx] = (int)((1L * nums[idx] * v) % MOD);
                idx = idx + k;
            }
        }

        int number = nums[0];

        for(int i=1; i<nums.length; i++){
            number = number ^ nums[i];

        }

        return number;
        
    }
}