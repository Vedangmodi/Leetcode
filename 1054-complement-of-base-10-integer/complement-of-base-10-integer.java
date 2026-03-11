class Solution {
    public int bitwiseComplement(int num) {
        if (num == 0) return 1;

        int bits = (int) Math.floor(Math.log(num)/ Math.log(2)) + 1;

        int mask = (1 << bits) - 1;

        return num ^ mask;


        
    }
}