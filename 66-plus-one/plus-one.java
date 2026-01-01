class Solution {
    public int[] plusOne(int[] nums) {

        for(int i=nums.length - 1; i>=0; i--){
            if(nums[i] + 1 != 10){
                nums[i] = nums[i] + 1;
                return nums;
            }
            else{
                nums[i] = 0;
                
            }
        }

        int[] arr = new int[nums.length + 1];
        arr[0] = 1;
        return arr;

    }
}


// 7, 8, 9

// 7, 9, 0