class Solution {
    public int countCommas(int n) {

        if(n < 1000){
            return 0;
        }
        // int count = 0;
        
        // if(n >= 1000 && n < 100000){
        //     int mod = n % 10;

        //     count = mod + 1;
        //     return count;
            
        // }

        // int max = 0;

        // if(n >= 100000){
        //     int mod = n % 10;

        //     max = mod * 2 + 2;

        //     return max;

            
        // }

        // return 0;

        return n - 999;

        
        
    }
}

// 1,000
// 10,000
// 1,00,000