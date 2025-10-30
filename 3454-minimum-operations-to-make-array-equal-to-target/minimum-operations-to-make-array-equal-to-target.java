class Solution {
    public long minimumOperations(int[] nums, int[] target) {
        long count = 0;
        int prev = 0;
        int curr = 0;;
        for(int i=0; i<nums.length; i++){
            curr = target[i] - nums[i];
            if((curr > 0 && prev < 0) || (curr < 0 && prev > 0)){
                count = count + Math.abs(curr);
            }
            else if(Math.abs(curr) > Math.abs(prev)){
                count = count + Math.abs(curr - prev);

            }
            prev = curr;
 
        }   
        return count;  
    }
}