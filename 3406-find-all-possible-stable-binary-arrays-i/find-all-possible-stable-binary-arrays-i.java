class Solution {
    int M = 1_000_000_007;
    Integer dp[][][]; // memo

    public int numberOfStableArrays(int zero, int one, int limit) {
        dp = new Integer[zero + 1][one + 1][2];  //memo

        int z = fun(zero, one, limit, true);
        int o = fun(zero, one, limit, false);

        return (z + o) % M;
        
    }
    public int fun(int zero, int one, int limit, boolean lastwasone){
        if(zero == 0 && one == 0){
            return 1;
        }

        int last = -1;

        if(lastwasone){
            last = 1;

        }
        else{
            last = 0;
        }

        if(dp[zero][one][last] != null){
            return dp[zero][one][last];
        }

        int res = 0;

        // for 0
        if(lastwasone){
            for(int i=1; i<=Math.min(zero, limit); i++){
                res = (res + fun(zero - i, one, limit, false)) % M;

            }

        }
        // for 1
        else{
            for(int i=1; i<=Math.min(one, limit); i++){
                res = (res + fun(zero, one - i, limit, true)) % M;

            }
        }

        dp[zero][one][last] = res;

        return res;
    }
}