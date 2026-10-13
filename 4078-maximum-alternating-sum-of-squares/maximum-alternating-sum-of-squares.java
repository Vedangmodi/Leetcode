class Solution {
    public long maxAlternatingSum(int[] arr) {
        int n = arr.length;

        for(int i=0; i<n; i++){
            arr[i] = arr[i] * arr[i];
        }

        Arrays.sort(arr);

        long ans = 0;

        for(int i=0; i<n/2; i++){
            ans -= arr[i];
        }

        for(int i = n/2; i<n; i++){
            ans += arr[i];
        }

        return ans;


        
        
        
    }
}