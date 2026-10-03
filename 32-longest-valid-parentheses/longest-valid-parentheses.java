class Solution {
    public int longestValidParentheses(String str) {
        int n = str.length();

        int open = 0;
        int close = 0;
        int res = 0;

        for(int i=0; i<n; i++){
            if(str.charAt(i) == '('){
                open++;
            }
            else{
                close++;
            }

            if(open == close){
                res = Math.max(res, open + close);
            }
            else if(close > open){
                close = 0;
                open = 0;
            }
        }


        open = 0;
        close = 0;

        for(int i=n-1; i>=0; i--){
            if(str.charAt(i) == '('){
                open++;
            }
            else{
                close++;
            }

            if(open == close){
                res = Math.max(res, open + close);
            }
            else if(close < open){
                close = 0;
                open = 0;
            }
        }

        return res;
        
    }
}