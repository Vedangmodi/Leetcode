class Solution {
    public int firstStableIndex(int[] nums, int k) {

        int n = nums.length;
        
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i=0; i<n; i++){
            
            max = Math.max(nums[i], max);
            arr1[i] = max;
            
        }

        for(int i=n-1; i>=0; i--){
            min = Math.min(min, nums[i]);
            arr2[i] = min;
        }

        int count = -1;

        for(int i=0; i<n; i++){
            if(arr1[i] - arr2[i] <= k){
                count = i;
                break;
            }
        }

        return count;
        
    }
}