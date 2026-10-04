class Solution {
    public boolean checkValidString(String str) {
        int n = str.length();

        int[][] memo = new int[n+1][n+1];
        for(int[] arr : memo){
            Arrays.fill(arr, -1);
        }
        return solve(0, 0, str, memo);
        
    }

    public boolean solve(int i, int open, String str, int[][] memo){
        if(i == str.length()){
            return (open == 0);
        }

        if(memo[i][open] != -1){
            return memo[i][open] == 1;
        }

        boolean isValid = false;

        if(str.charAt(i) == '*'){
            isValid |= solve(i + 1, open + 1, str, memo);

            isValid |= solve(i + 1, open, str, memo);

            if(open > 0){
                isValid |= solve(i + 1, open - 1, str, memo);
            }

        }
        else if(str.charAt(i) == '('){
            isValid = solve(i + 1, open + 1, str, memo);
        }
        else{
            if(open > 0){
                isValid = solve(i + 1, open - 1, str, memo);
            }

        }

        memo[i][open] = isValid ? 1 : 0;

        return isValid;


    }
}