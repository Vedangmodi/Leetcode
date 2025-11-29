class Solution {
    public int trap(int[] arr) {
        int[] arr1 = pmax(arr);
        int[] arr2 = smax(arr);

        int count = 0;

        for(int i=0; i<arr.length; i++){
            count = count + Math.min(arr1[i], arr2[i]) - arr[i];
        }

        return count;
        
    }

    public int[] pmax(int[] arr){
        int[] nums = new int[arr.length];
        nums[0] = arr[0];

        for(int i=1; i<arr.length; i++){
            nums[i] = Math.max(nums[i-1], arr[i]);
        }

        return nums;
    }

    public int[] smax(int[] arr){
        int[] nums = new int[arr.length];
        nums[arr.length - 1] = arr[arr.length - 1];

        for(int i=arr.length - 2; i>=0; i--){
            nums[i] = Math.max(nums[i+1], arr[i]);
        }

        return nums;
    }
}