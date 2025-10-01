class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int a = numBottles;
        int count = 0;
        int x = numExchange - 1;

        while(a >= numExchange){
            a = a - x;
            count++;


        }
        return numBottles + count;

        

        

        
    }
}