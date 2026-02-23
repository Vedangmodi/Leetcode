class Solution {
    public boolean hasAllCodes(String s, int k) {

        int totalNeeded = 1 << k;   // total binary codes possible = 2^k
        boolean[] seen = new boolean[totalNeeded];

        int mask = totalNeeded - 1; // keeps only last k bits
        int num = 0;
        int uniqueCount = 0;

        for (int i = 0; i < s.length(); i++) {

            // shift left and add current bit
            num = (num << 1) | (s.charAt(i) - '0');

            // keep only last k bits
            num = num & mask;

            // start checking only when window size reaches k
            if (i >= k - 1) {

                if (!seen[num]) {
                    seen[num] = true;
                    uniqueCount++;
                }

                // if all binary codes found
                if (uniqueCount == totalNeeded)
                    return true;
            }
        }

        return false;
    }
}