class Solution {
    public int maxDistance(int[] arr) {
        int i = 0;
        int j = arr.length - 1;

        int max1 = 0;

        while(i < j){
            if(arr[i] != arr[j]){
                max1 = Math.abs(i - j);
                break;
            }
            else {
                j--;
            }
        }

        int n = 0;
        int m = arr.length - 1;

        int max2 = 0;

        while(n < m){
            if(arr[n] != arr[m]){
                max2 = Math.abs(n - m);
                break;
            }
            else{
                n++;
            }
        }

        return Math.max(max1, max2);
        
    }
}