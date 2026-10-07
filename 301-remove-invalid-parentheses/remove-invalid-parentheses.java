class Solution {
    int n;
    int maxLen;
    HashSet<String> set = new HashSet<>();

    public List<String> removeInvalidParentheses(String str) {
        n = str.length();
        maxLen = 0;

        solve(0, str, 0, new StringBuilder());

        return new ArrayList<>(set);
        
    }

    public void solve(int i, String str, int count, StringBuilder sb){
        if(count < 0){
            return;

        }
        if(i == n){
            if(count == 0){
                if(sb.length() > maxLen){
                    maxLen = sb.length();
                    set.clear();
                }

                if(maxLen == sb.length()){
                    set.add(sb.toString());
                }

            }
            

            return;
        }

        char ch = str.charAt(i);

        if(ch != '(' && ch != ')'){
            sb.append(ch);
            solve(i+1, str, count, sb);
            sb.deleteCharAt(sb.length() - 1);
            return;

        }

        sb.append(ch);

        solve(i+1, str, count + (ch == '(' ? 1 : -1), sb);
        sb.deleteCharAt(sb.length() - 1);


        solve(i+1, str, count, sb);

        
    }
}