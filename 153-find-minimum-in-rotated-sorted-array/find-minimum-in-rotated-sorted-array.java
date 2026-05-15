class Solution {
    public int findMin(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        int min = arr[0];

        while(start < end){
            int mid = start + (end - start)/2;
            if(arr[mid] > arr[end]){
                start = mid + 1;
            }
            else{
                end = mid;
            }
            // if(arr[mid] >= arr[start] && arr[mid] <= arr[end]){
            //     min = arr[start];
            //     end = mid;
            // }
            // else if(arr[mid] <= arr[start] && arr[mid] >= arr[end]){
            //     min = arr[end];
            //     start = mid + 1;
            // }

            // else if(arr[mid] >= arr[start]){
            //     min = arr[start];
            //     start = mid + 1;
                
            // }
            // else if(arr[mid] <= arr[end]){
            //     min = arr[mid]; 
            //     end = mid;
                 
            // }
            
        }

        return arr[start];

        
    }
}