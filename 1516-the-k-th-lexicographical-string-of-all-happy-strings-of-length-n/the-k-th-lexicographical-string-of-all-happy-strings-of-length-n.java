class Solution {
    int count = 0;
    String result = "";
    
    public String getHappyString(int n, int k) {
        StringBuilder sb = new StringBuilder();
        backtrack(sb,n,k);

        return result;
    }

    public void backtrack(StringBuilder sb, int n,int k){
        if(sb.length() == n){
            count++;
            if(count == k){
                result = sb.toString();
            }
            return;
        }

        for(char ch = 'a'; ch<='c'; ch++){
            if(sb.length() > 0 && sb.charAt(sb.length() - 1) == ch){
                continue;
            }
            // Do
            sb.append(ch);

            //Explore
            backtrack(sb, n, k);

            //Undo
            sb.deleteCharAt(sb.length() - 1);

        }
    }
}