class Solution {
    static final int m = 1_000_000_007;
    public int numSub(String str) {
        long count = 0;
        int i = 0;

        long ans = 0;

        while(i < str.length()){
            if(str.charAt(i) - '0' == 0){
                count = 0;
                i++;
            }

            while(i < str.length() && str.charAt(i) - '0' == 1){
                count++;
                ans = (ans + count) % m;
                i++;
            }

            // ans = ans + (count * (count + 1) / 2);
        }

        return (int) ans;
        
    }
}