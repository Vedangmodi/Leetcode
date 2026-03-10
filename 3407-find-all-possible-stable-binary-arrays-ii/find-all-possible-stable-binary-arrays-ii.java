class Solution {

    int MOD = 1_000_000_007;

    public int numberOfStableArrays(int zero, int one, int limit) {

        int[][] dp0 = new int[zero + 1][one + 1]; // ending with 0
        int[][] dp1 = new int[zero + 1][one + 1]; // ending with 1

        for (int i = 1; i <= Math.min(zero, limit); i++) {
            dp0[i][0] = 1;
        }

        for (int i = 1; i <= Math.min(one, limit); i++) {
            dp1[0][i] = 1;
        }

        for (int z = 1; z <= zero; z++) {
            for (int o = 1; o <= one; o++) {

                // ending with 0
                dp0[z][o] = dp1[z - 1][o];

                if (z - limit - 1 >= 0) {
                    dp0[z][o] = (dp0[z][o] - dp1[z - limit - 1][o] + MOD) % MOD;
                }

                dp0[z][o] = (dp0[z][o] + dp0[z - 1][o]) % MOD;


                // ending with 1
                dp1[z][o] = dp0[z][o - 1];

                if (o - limit - 1 >= 0) {
                    dp1[z][o] = (dp1[z][o] - dp0[z][o - limit - 1] + MOD) % MOD;
                }

                dp1[z][o] = (dp1[z][o] + dp1[z][o - 1]) % MOD;
            }
        }

        return (dp0[zero][one] + dp1[zero][one]) % MOD;
    }
}