class Solution {
    public int largestInteger(int[] nums, int k) {

        int n = nums.length;

        int[] count = new int[51];
        int max = Integer.MIN_VALUE;

        for(int i=0; i<nums.length; i++){
            max = Math.max(max, nums[i]);
            count[nums[i]]++;

        }

        if(k == 1){
            int ans = -1;

            for(int i = 0; i <= 50; i++){
                if(count[i] == 1){
                ans = i;
                }
            }

            return ans;
        }

        if(k == nums.length){
            return max;
        }

        int ans = -1;

        if(count[nums[0]] == 1){
            ans = Math.max(ans, nums[0]);
        }

        if(count[nums[n - 1]] == 1){
            ans = Math.max(ans, nums[n - 1]);
        }
        return ans;




    }
}

