class Solution {
    public boolean isGood(int[] nums) {
        int n = nums.length;
        
        int[] arr = new int[nums.length];

        for(int i=0; i<nums.length; i++){
            if(nums[i] >= n){
                return false;
            }
            arr[nums[i] - 1]++;

        }

        for(int i=0; i<n; i++){
            if(i  == n - 1 && arr[i] != 0){
                return false;
            }

            if(i == n - 2 && arr[i] != 2){
                return false;

            }
            else if(i  < n - 2 && arr[i] != 1){
                return false;
                
            }
        }

        return true;
        
    }
}

//  nums = [1, 3, 3, 2]
//  arr = {1, 1, 2, 0};