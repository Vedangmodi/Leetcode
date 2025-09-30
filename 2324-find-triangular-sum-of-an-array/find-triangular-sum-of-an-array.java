class Solution {
    public int triangularSum(int[] arr) {

        int n = arr.length;

        for(int i=n-1; i>0; i--){
            for(int j=0; j<i; j++){
                arr[j] = (arr[j] + arr[j + 1]) % 10;

            }
        }
        
        return arr[0];
    }
}