class Solution {
    
    public int maximumJumps(int[] nums, int target) {
        int[] memo = new int[nums.length + 1];
        Arrays.fill(memo, Integer.MIN_VALUE);

        int x = solve(nums, target, 0, memo);

        return x < 0 ? -1 : x;
        
    }
    public int solve(int[] nums, int target, int i, int[] memo){
        int n = nums.length;
        int res = Integer.MIN_VALUE;

        if(i == n - 1){
            return 0;
        }

        if(memo[i] != Integer.MIN_VALUE){
            return memo[i];

        }

        for(int j=i+1; j<n; j++){
            if(Math.abs(nums[i] - nums[j]) <= target){
                int temp = 1 + solve(nums, target, j, memo);

                res = Math.max(res, temp);

            }
        }

        return memo[i] = res;
    }
}