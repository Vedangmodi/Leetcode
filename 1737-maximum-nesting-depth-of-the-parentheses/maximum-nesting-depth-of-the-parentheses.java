class Solution {
    public int maxDepth(String str) {
        int max = 0;
        int count = 0;

        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);

            if(ch == '('){
                count++;
            }
            else if(ch == ')'){
                count--;
            }

            max = Math.max(count, max);


        }
        return max;
        
    }
}

