class Solution {

    private static final long MOD = 1_000_000_007L;

    public int zigZagArrays(int n, int l, int r) {

        int m = r - l + 1;

        long[] dp = new long[m];
        Arrays.fill(dp, 1);

        for(int len = 2; len <= n; len++) {

            long[] ndp = new long[m];

            if(len % 2 == 0) {

                long pref = 0;

                for(int j = 0; j < m; j++) {
                    ndp[j] = pref;
                    pref = (pref + dp[j]) % MOD;
                }

            } else {

                long suff = 0;

                for(int j = m - 1; j >= 0; j--) {
                    ndp[j] = suff;
                    suff = (suff + dp[j]) % MOD;
                }
            }

            dp = ndp;
        }

        long ans = 0;

        for(long x : dp) {
            ans = (ans + x) % MOD;
        }

        ans = (ans * 2) % MOD;

        return (int) ans;
    }
}