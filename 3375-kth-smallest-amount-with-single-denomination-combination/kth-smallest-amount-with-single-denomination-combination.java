class Solution {

    private long countSmaller(long mid, int[] coins) {
        long count = 0;
        int n = coins.length;

        for (int mask = 1; mask < (1 << n); mask++) {
            long lcm = 0;
            int order = 0;

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    order++;

                    if (lcm == 0) {
                        lcm = coins[i];
                    } else {
                        lcm = lcm * coins[i] / gcd(lcm, coins[i]);
                    }
                }
            }

            if (order % 2 == 1) {
                count += mid / lcm;
            } else {
                count -= mid / lcm;
            }
        }

        return count;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    public long findKthSmallest(int[] coins, int k) {
        long result = -1;

        int maxCoin = 0;
        for (int coin : coins) {
            maxCoin = Math.max(maxCoin, coin);
        }

        long left = 1;
        long right = (long) maxCoin * k;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            if (countSmaller(mid, coins) >= k) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }
}