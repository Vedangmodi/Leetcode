class Solution {
    public int countHillValley(int[] arr) { 
        int count = 0;

        for(int i=1; i<arr.length - 1; i++){
            if(arr[i] == arr[i+1]){
                continue;
            }

            int left = i - 1;
            while(left >= 0 && arr[left] == arr[i]){
                left--;
            }

            int right = i + 1;
            while(right <= arr.length && arr[i] == arr[right]){
                right++;
            }

            if(left >= 0 && right < arr.length){
                if(arr[left] < arr[i] && arr[i] > arr[right]){
                    count++;

                }
                else if(arr[left] > arr[i] && arr[i] < arr[right]){
                    count++;
                }
            }

        }

       
        return count;

    }
}