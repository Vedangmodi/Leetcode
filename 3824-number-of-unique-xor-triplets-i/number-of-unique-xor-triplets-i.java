class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;

        if(n == 2 || n == 1){
            return n;
        }

        int ans = 1;

        while(ans <= n){
            ans = (ans << 1);
        }

        return ans;

        
    }
}