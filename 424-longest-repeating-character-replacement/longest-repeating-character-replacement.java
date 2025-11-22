class Solution {
    public int characterReplacement(String str, int k) {
        HashMap<Character, Integer> map = new HashMap<>();

        int maxfreq = 0;
        int max = 0;

        int j = 0;

        for(int i=0; i<str.length(); i++){

            char ch = str.charAt(i);

            map.put(ch, map.getOrDefault(ch, 0) + 1);
                
            maxfreq = Math.max(map.get(ch), maxfreq);
            
            while((i - j + 1) - maxfreq > k && j <= i){
                char ch1 = str.charAt(j);
                if(map.get(ch1) > 1){
                    map.put(ch1, map.getOrDefault(ch1 , 0) - 1);
                }
                else if(map.get(ch1) == 1){
                    map.remove(ch1);
                }
                j++;
                
            }

            max = Math.max(max, (i - j + 1));
        }

        return max;
        
    }
}