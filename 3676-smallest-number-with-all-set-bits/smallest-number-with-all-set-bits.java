class Solution {
    public int smallestNumber(int n) {
        int res = n;
        while(res >= n){
            if((res & (res + 1)) == 0){
                return res;
            }
            else{
                res++;
            }

        }
        return -1;
        
    }
}