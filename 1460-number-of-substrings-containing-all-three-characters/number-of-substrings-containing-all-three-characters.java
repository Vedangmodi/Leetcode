class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();

        int count = 0;
        int currCount = 0;
        int[] arr = new int[3];
        int left = 0;

        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            arr[ch - 'a']++;
            if(arr[ch - 'a'] == 1){
                currCount++;
            }

            while(currCount == 3){
                count = count + n - i;

                char ch1 = s.charAt(left);
                arr[ch1 - 'a']--;
                
                if(arr[ch1 -'a'] == 0){
                    currCount--;
                }
                left++;


            }

        }
        return count;
        
    }
}