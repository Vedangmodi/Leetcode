class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int ans = 0;

        for(int i=0; i<nums.length; i++){
            int count = 0;

            int x = 0;

            for(int j=i; j<nums.length; j++){
                if(nums[j] == target){
                    count++;
                    
                }
                int len = j - i + 1;

                if(len/2 < count){
                    x++;

                }
            }
            ans = ans + x;
        }
        return ans;  
    }
}

// 1 2 