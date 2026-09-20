class Solution {
    public int reverseDegree(String str) {
        int ans= 0;

        for(int i=0; i<str.length(); i++){
            int num = 26 - (str.charAt(i) - 'a' + 1) + 1;
            ans += num * (i + 1); 

        }

        return ans;
        
    }
}