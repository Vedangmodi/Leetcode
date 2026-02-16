class Solution {
    public int reverseBits(int n) {
        int result = 0;

        for(int i=0; i<32; i++){
            int bits = n & 1;
            result = (result << 1) | bits;

            // >> → signed right shift (keeps sign bit)
            // >>> → unsigned right shift (fills with 0)

            n = n >>> 1;

        }

        return result;
        
    }
}