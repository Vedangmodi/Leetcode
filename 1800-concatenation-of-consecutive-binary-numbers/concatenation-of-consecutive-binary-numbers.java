class Solution {
    public int concatenatedBinary(int n) {
        // StringBuilder sb = new StringBuilder();
        int bit = 0;
        long res = 0;
        int mod = 1_000_000_007;

        for(int i=1; i<=n; i++){
            // int bits = Integer.numberOfLeadingZeros(i);

            if((i & (i - 1)) == 0){
                bit++;
            }

            res = ((res << bit) % mod + i) % mod;

        }

        return (int) res;

        
    }
}