class Solution {
    public int smallestRepunitDivByK(int k) {

        if(k % 2 == 0){
            return -1;
        }

        int ans = 1;
        int count = 1;

        for(int i=0; i<=k; i++){
            if(ans % k == 0){
                return count;
            }
            else{
                ans = (ans % k) * 10 + 1;
                count++;
            }
        }

        return -1;


        
    }
}