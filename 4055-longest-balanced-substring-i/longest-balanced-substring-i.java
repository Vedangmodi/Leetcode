class Solution {
    public int longestBalanced(String str) {

        int ans = 0;

        for(int i=0; i<str.length(); i++){

            int[] arr = new int[26];

            int count = 0;
            int dist = 0;
            
            for(int j=i; j<str.length(); j++){
                int x = str.charAt(j) - 'a';

                if(arr[x] == 0){
                    count++;
                }

                arr[x]++;

                dist = Math.max(dist, arr[x]);
                int len = j - i + 1;

                if(len == count * dist){
                    ans = Math.max(ans,len );

                }

                



            }

        }

        return ans;
        
    }
}


// ab