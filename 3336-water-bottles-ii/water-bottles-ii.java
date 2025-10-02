class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int x = numBottles;
        int y = numExchange;

        int count = 0;

        while(x >= y){
            x = x - y;
            y = y + 1;
            x++;
            count++;
        }

        return numBottles + count;
    }
}