class Solution {
    public boolean kLengthApart(int[] arr, int k) {
        int j = 0;

        while(j < arr.length){
            if(arr[j] == 0){
                j++;
            }
            else{
                break;
            }

        }

        for(int i=0; i<arr.length; i++){
            if(arr[i] == 1 && j < i){
                if(i - j - 1 < k){
                    return false;
                }

            }

            if(arr[i] == 1){
                j = i;
            }
        }

        return true;
        
    }
}