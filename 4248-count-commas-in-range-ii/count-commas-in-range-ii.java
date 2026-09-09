class Solution {
    public long countCommas(long n) {

        if(n < 1000){
            return 0;
        }

        long start = 1000;
        int comma = 1;

        long ans = 0;
        

        while(start <= n){
            long end = start * 1000 - 1;

            long last = Math.min(n, end);

            long count = last - start + 1;

            ans += count * comma;

            start = start * 1000;
            comma++;
            
        }

        return ans;
        
    }
}