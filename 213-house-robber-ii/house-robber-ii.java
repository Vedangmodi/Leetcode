class Solution {
    int[] dp = new int[101];

    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 1){
            return nums[0];
        }

        if(n == 2){
            return Math.max(nums[0], nums[1]);
        }

        Arrays.fill(dp, -1);
        int op1 = solve(nums, n, 1);

        Arrays.fill(dp, -1);
        int op2 = solve(nums, n - 1, 0);

        return Math.max(op1, op2);
        
    }

    public int solve(int[] nums, int n, int i){
        if(i >= n){
            return 0;
        }

        if(dp[i] != -1){
            return dp[i];
        }

        int take = nums[i] + solve(nums, n, i+2);
        int skip = solve(nums, n, i+1);

        return dp[i] = Math.max(take, skip);


    }
}