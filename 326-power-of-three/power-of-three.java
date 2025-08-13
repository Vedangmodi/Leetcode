class Solution {
    public boolean isPowerOfThree(int n) {
        if(n<=0){
            return false;
        }
        
        double num = Math.log10(n)/Math.log10(3);

        if(num == (int)num){
            return true;
        }
        else{
            return false;
        }
    }

   
}