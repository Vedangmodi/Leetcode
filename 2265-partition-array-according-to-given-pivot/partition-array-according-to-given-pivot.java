class Solution {
    public int[] pivotArray(int[] nums, int p) {
        int n = nums.length;

        int[] arr = new int[nums.length];
        int x = 0;

        for(int i=0; i<n; i++){
            if(nums[i] < p){
                arr[x] = nums[i];
                x++;
            }

        }

        for(int i=0; i<n; i++){
            if(nums[i] == p){
                arr[x] = nums[i];
                x++;
            }

        }

        for(int i=0; i<n; i++){
            if(nums[i] > p){
                arr[x] = nums[i];
                x++;
            }

        }

        return arr;
        
    }
}