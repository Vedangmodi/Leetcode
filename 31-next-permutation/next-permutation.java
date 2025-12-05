class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while(i >= 0 && nums[i + 1] <= nums[i]){
            i--;
            
        }

        int j = nums.length - 1;
        if(i >= 0){
            while( nums[i] >= nums[j]){
                j--;
            }
            swap(nums, i, j);
            
        }
        reverse(nums, i + 1, nums.length - 1);


    }
    public void swap(int[] arr,int x,int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public void reverse(int[] arr, int x, int y){
        while(x < y){
            swap(arr, x, y);
            x++;
            y--;
        }

    }
}
