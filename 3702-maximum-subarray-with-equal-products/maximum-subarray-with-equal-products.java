class Solution {
    public int maxLength(int[] nums) {
        int res = 2;
        int prodVal = 1;
        int n = nums.length;
        int start = 0,
            end = 0;

        while (end < n) {
            while (gcd(prodVal, nums[end]) > 1) {
                prodVal /= nums[start];
                start++;
            }
            prodVal *= nums[end];
            res = Math.max(res, end - start + 1);
            end++;
        }
        return res;
    }

    public int gcd(long a , long b){
        while(b != 0){
            long temp = b;
            b = a % b;
            a = temp;
        }

        return (int)a;
    }
}