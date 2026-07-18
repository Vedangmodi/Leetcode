class Solution {
    public int findGCD(int[] nums) {
        int mn = 1001, mx = 0;

        for (int num : nums) {
            if (num < mn)
                mn = num;
            if (num > mx)
                mx = num;
        }

        return gcd(mn, mx);
    }
    private int gcd(int a, int b) {
        if(b == 0){
            return a;
        }

        return gcd(b, a % b);
    }
}