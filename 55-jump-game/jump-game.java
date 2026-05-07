class Solution {
    int[] t = new int[10001];
    public boolean canJump(int[] nums) {
        return solve(nums, nums.length, 0);
        
    }

    public boolean solve(int[] nums, int n, int idx){
        if(idx == n - 1){
            return true;
        }

        if(idx >= n){
            return false;
        }

        if(t[idx] != 0){
            return t[idx] == 1;
        }

        for(int i=1; i<=nums[idx]; i++){
            if(solve(nums, n, idx + i) == true){
                t[idx] = 1;
                return true;
            }
        }

        t[idx] = -1;

        return false;

    }
}