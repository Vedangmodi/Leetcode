class Solution {
    public int[] maxValue(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = nums[0];
        right[n-1] = nums[n-1];

        for(int i=1; i<n; i++){
            left[i] = Math.max(left[i - 1], nums[i]);
        }

        for(int i=n-2; i>=0; i--){
            right[i] = Math.min(nums[i], right[i + 1]);
        }

        int[] arr = new int[n];

        arr[n - 1] = left[n - 1];

        for(int i = n-2; i>=0; i--){
            if(left[i] <= right[i + 1]){
                arr[i] = left[i];
            }
            else{
                arr[i] = arr[i + 1];
            }
        }

        return arr;


        
    }
}