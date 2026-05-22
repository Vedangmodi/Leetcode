class Solution {
    public int search(int[] nums, int target) {
        int pivotPt = pivot(nums);

        if(pivotPt == -1){
            return binarySearch(nums, 0, nums.length - 1, target);
        }

        if(nums[pivotPt] == target){
            return pivotPt;
        }
        if(target >= nums[0]) {
            return binarySearch(nums, 0, pivotPt - 1, target);
        }
        
        //  if(target < nums[0]){
        //     return binarySearch(nums, pivotPt + 1, nums.length - 1, target);
        // }
        
            return binarySearch(nums, pivotPt + 1, nums.length - 1, target);
            
        
        
        
    }

    public int pivot(int[] arr){
        int start = 0;
        int end  = arr.length - 1;

        while(start <= end){
            int mid = start + (end - start)/2;

            if(mid < end && arr[mid] > arr[mid + 1]){
                return mid;
            }
            if(mid > start && arr[mid - 1] > arr[mid]){
                return mid - 1;
            }
            if(arr[mid] <= arr[start]){
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }

        }
        return - 1;
    }

    public int binarySearch(int[] arr, int start, int end, int target){

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(arr[mid] > target){
                end = mid - 1;
            }
            else if(arr[mid] < target){
                start = mid + 1;
            }
            else{
                return mid;
            }

        }
        return -1;
    }
    
}