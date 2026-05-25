class Solution {
    int[] memo;

    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        memo = new int[n];

        Arrays.fill(memo, -1);

        int res = 1;

        for(int i = 0; i<n; i++){
            res = Math.max(res,solve(arr, i, d));
        }

        return res;

       
    }

    public int solve(int[] arr, int i, int d){

        if(memo[i] != -1){
            return memo[i];
        }

        int n = arr.length;

        int res = 1;

        // right
        for(int j = i + 1; j <= Math.min(n - 1, i + d); j++){
            if(arr[j] >= arr[i]){
                break;
            }

            res = Math.max(res, 1 + solve(arr, j, d));
        }

        // left
        for(int j = i - 1; j >= Math.max(0, i - d); j--){
            if(arr[j] >= arr[i]){
                break;
            }

            res = Math.max(res, 1 + solve(arr, j, d));
        }

        return memo[i] = res;


    }
}
