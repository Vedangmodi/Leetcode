class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int min = nums.length + 1;

        for(int i=start; i<nums.length; i++){
            if(nums[i] == target){
                min = Math.min(min, Math.abs(i - start));
            }

        }

        for(int i = start; i>=0; i--){
            if(nums[i] == target){
                min = Math.min(min, Math.abs(i - start));
            }

        }

        return min;
    }
}