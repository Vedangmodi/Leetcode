class Solution {
    public int maxRotateFunction(int[] nums) {
        int sum = 0;
        int f0 = 0;

        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            f0 += nums[i] * i; 
        }

        int n = nums.length - 1;

        int max = f0;

        for(int i=0; i<nums.length; i++){
            int fn = f0 + sum - (nums.length * nums[n]);
            max = Math.max(max, fn);

            n--;
            f0 = fn;

        }

        return max;
        
    }
}