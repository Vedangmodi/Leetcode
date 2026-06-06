class Solution {
    public int[] leftRightDifference(int[] nums) {
        int x = 0;

        int[] arr = new int[nums.length];

        for(int i=0; i<arr.length; i++){
            int y = nums[i];
            arr[i] = x;
            x = x + y;
        }

        int a = 0;
        
        for(int i = arr.length - 1; i>=0; i--){
            int b = nums[i];
            arr[i] = Math.abs(a - arr[i]);
            a = b + a;


        }

        return arr;
        
    }
}