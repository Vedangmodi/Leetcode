class Solution {
    public int maximumLengthSubstring(String str) {
        int[] arr = new int[26];

        int j = 0;
        int max = 0;

        for(int i=0; i<str.length(); i++){
            int x = str.charAt(i) - 'a';
            arr[x]++;

            while(arr[x] > 2){
                int y = str.charAt(j) - 'a';

                arr[y]--;
                j++;
            }
            max = Math.max(max, i - j + 1);
        }

        return max;

       
        
    }
}