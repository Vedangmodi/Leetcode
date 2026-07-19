class Solution {
    public String smallestSubsequence(String str) {
        int n = str.length();

        int[] last = new int[26];

        for(int i=n-1; i>=0; i--){
            if(last[str.charAt(i) - 'a'] == 0){
                last[str.charAt(i) - 'a'] = i;
            }
        }

        boolean[] arr = new boolean[26];

        Stack<Character> stack = new Stack<>();

        for(int i=0; i<n; i++){
            char ch = str.charAt(i);
            // if(stack.isEmpty()){
            //     stack.push(ch);
            //     arr[ch - 'a'] = true;
            //     continue;
            // }
            
            // if(stack.peek() < ch){
            //     stack.push(ch);
            //     arr[ch - 'a'] = true;
            //     continue;
            // }

            if(arr[str.charAt(i) - 'a']){
                continue;
            }

            while(!stack.isEmpty() && stack.peek() > ch && last[stack.peek() - 'a'] > i){
                arr[stack.pop() - 'a'] = false;   
            }

            stack.push(ch);
            arr[ch - 'a'] = true;

            
        }
            StringBuilder sb = new StringBuilder();
            for (char c : stack) sb.append(c);
            return sb.toString();
    }
}