class Solution {
    // public int rob(int[] nums) {
    //     int n = nums.length;

    //     if(n == 0){
    //         return 0;
    //     }

    //     if(n == 1){
    //         return nums[0];
    //     }

    //     int[] arr = new int[n];    

    //     arr[0] = nums[0];
    //     arr[1] = Math.max(nums[0],nums[1]);

    //     for(int i=2; i<n; i++){
    //         arr[i] = Math.max(nums[i] + arr[i - 2],arr[i - 1]);

    //     }

    //     return arr[n - 1];
    // }

    int[] dp = new int[101];

    public int solve(int[] nums, int i, int n){
        if(i >= n){
            return 0;
        }

        if(dp[i] != -1){
            return dp[i];
        }

        int steal = nums[i] + solve(nums, i + 2, n);
        int skip = solve(nums, i + 1, n);

        return dp[i] = Math.max(steal, skip);

    }

    public int rob(int[] nums) {
        int n = nums.length;

        Arrays.fill(dp, -1);

        return solve(nums, 0, n);

    }

    
}