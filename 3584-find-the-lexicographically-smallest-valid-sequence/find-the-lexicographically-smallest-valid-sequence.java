class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[] suffixMatch = new int[n + 1];
        suffixMatch[n] = 0;

        int j = m - 1;
        for (int i = n - 1; i >= 0; i--) {
            suffixMatch[i] = suffixMatch[i + 1];
            if (j >= 0 && word1.charAt(i) == word2.charAt(j)) {
                suffixMatch[i] = suffixMatch[i + 1] + 1;
                j--;
            }
        }

        int[] result = new int[m];
        int i = 0;
        int k = 0;
        boolean usedChange = false;

        while (i < n && k < m) {
            if (word1.charAt(i) == word2.charAt(k)) {
                result[k] = i;
                k++;
                i++;
            } else if (!usedChange) {
                if (suffixMatch[i + 1] >= m - k - 1) {
                    result[k] = i;
                    usedChange = true;
                    k++;
                    i++;
                } else {
                    i++;
                }
            } else {
                i++;
            }
        }

        if (k == m) {
            return result;
        }
        return new int[0];
    }
}