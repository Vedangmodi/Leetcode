class Solution {
    public int gcdOfOddEvenSums(int n) {
        int odd = 0;
        int oddnum = 1;

        for(int i=0; i<n; i++){
            odd += oddnum;
            oddnum += 2;

        }

        int even = 0;
        int evennum = 2;

        for(int i=0; i<n; i++){
            even += evennum;
            evennum += 2;

        }

        return gcd(odd, even);


        
    }

    private int gcd(int a, int b) {
        if(b == 0){
            return a;
        }

        return gcd(b, a % b);
    }
}