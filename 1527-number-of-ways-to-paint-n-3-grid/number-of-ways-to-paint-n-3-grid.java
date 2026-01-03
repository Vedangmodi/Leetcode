class Solution {
    int mod = 1_000_000_007;

    public int numOfWays(int n) {
        if(n == 0){
            return 0;
        }

        long two = 6;
        long three = 6;

        n--;

        while(n > 0){
            long nextTwo = (3 * two + 2 * three) % mod;
            three = (three * 2 + two * 2) % mod;
            two = nextTwo;

            n--;

        }

        return (int) (two + three) % mod;
        
        
    }
}

// 2 -> 3 - 2 possibilities
// 2 -> 2 - 3 
// 3 -> 2 - 2
// 3 -> 3 - 2