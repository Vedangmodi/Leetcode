class Solution {
    public int shipWithinDays(int[] arr, int D) {
        int ans = 0;

        int start = 0;
        int end = 0;     

        for(int i = 0; i<arr.length; i++){
            start = Math.max(start, arr[i]);
            end += arr[i]; 
        }

        while(start <= end){
            int mid = start + (end - start)/2;

            if(isValid(arr, mid, D)){
                ans = mid;
                end = mid - 1;
                
            }
            else{
                start = mid + 1;
                
            }
        }

        return ans;
        
    }

    public static Boolean isValid(int[] arr, int mid, int b){
        int count = 1;
        int sum = 0;

        for(int i=0; i<arr.length; i++){
            
            if(sum + arr[i] <= mid){
                sum += arr[i];
            }
            else if(sum + arr[i] > mid){
                sum = arr[i];
                count++;
            }
        }

        return count <= b;


    }
}
