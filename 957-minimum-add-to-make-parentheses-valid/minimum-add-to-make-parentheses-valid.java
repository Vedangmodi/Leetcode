class Solution {
    public int minAddToMakeValid(String str) {

        int open = 0;
        int close = 0;

        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);

            if(ch == '('){
                open++;
            }
            else if(open > 0){
                open--;
            }
            else{
                close++;
            }
        }

        return open + close;
        
    }
}