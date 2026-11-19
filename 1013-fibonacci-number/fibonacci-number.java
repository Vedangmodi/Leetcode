class Solution {
    // public int fib(int n) {
    //     if(n <= 1){
    //         return n;
    //     }

        // int num1 = 0;
        // int num2 = 1;

        // for(int i=2; i<=n; i++){
        //     int temp = num1 + num2;
        //     num1 = num2;
        //     num2 = temp;

        // }
        // return num2;

//         return fib(n - 1) + fib(n - 2);
        
//     }

    int[] dp = new int[31];

    public int fib(int n) {
        Arrays.fill(dp, -1);

        return solve(n);

    }

    public int solve(int n){
        if(n <= 1){
            return n;
        }

        if(dp[n] != -1){
            return dp[n];
        }

        return dp[n] = solve(n - 1) + solve(n - 2);

    }
}