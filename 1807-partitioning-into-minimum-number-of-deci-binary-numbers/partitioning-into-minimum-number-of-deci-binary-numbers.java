class Solution {
    public int minPartitions(String str) {
        int max = 1;

        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);

            max = Math.max(max, ch - '0');
        }

        return max;
        
    }
}