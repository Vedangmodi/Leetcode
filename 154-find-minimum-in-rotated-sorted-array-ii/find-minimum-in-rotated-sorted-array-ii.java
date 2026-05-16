class Solution {
    public int findMin(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        int idx = 0;

        while(start <= end){
            

            while(start < end && arr[start + 1] == arr[start]){
                start++;

            }
            while(start < end && arr[end] == arr[end - 1]){
                end--;
            }

            int mid = start + (end - start)/2;

            if(arr[idx] > arr[mid]){
                idx = mid;
            }

            if(arr[end] < arr[mid]){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }

        return arr[idx];
        
    }
}