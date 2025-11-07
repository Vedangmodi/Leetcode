class Solution {
    public int maxScore(int[] arr, int k) {

        int sum = 0;
        int maxsum = 0;

        for(int i=0; i<k; i++){
            sum = sum + arr[i];
        }

        maxsum = sum;

        int x = k - 1;
        int j = arr.length - 1;

        while(x >= 0 ){
            

            sum = sum + arr[j] - arr[x];
            maxsum = Math.max(sum, maxsum);
            j--;
            x--;

            
        }

        return maxsum;

    }

    
}