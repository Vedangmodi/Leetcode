class Solution {
    public int splitArray(int[] arr, int k) {

        int start = 0;
        int end = 0;

        for(int i = 0; i<arr.length; i++){
            start = Math.max(start, arr[i]);
            end += arr[i];

        }

        int ans = 0;

        while(start <= end){
            int mid = start + (end - start)/2;

            if(isValid(arr, mid, k)){
                ans = mid;
                end = mid - 1;

            }
            else{
                start = mid + 1;
            }
        }

        return ans;
    }

    public boolean isValid(int[] arr, int capacity, int k){
        int student = 1;
        int pages = 0;

        for(int i=0; i<arr.length; i++){
            if(pages + arr[i] <= capacity){
                pages += arr[i];
            }
            else{
                student++;
                pages = arr[i];

            }
        }

        if(student <= k){
            return true;
        }
        else{
            return false;
        }
    }
}