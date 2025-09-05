class Solution {
    public int makeTheIntegerZero(int num1, int num2) {

        long val;
        for(int i=1; i<=60; i++){
            val =(long) num1 - (long) i * (long) num2;
            // if(val < 0) continue;

            if(Long.bitCount(val) <= i && i <= val){
                return i;
            }

        }
        return -1;  
    }
}