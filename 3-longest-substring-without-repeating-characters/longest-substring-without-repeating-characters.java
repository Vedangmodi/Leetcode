class Solution {
    public int lengthOfLongestSubstring(String str) {

        HashSet<Character> set = new HashSet<>();
        int x = 0;
        int max = 0;

        for(int i=0; i<str.length(); i++){
            while(set.contains(str.charAt(i))){
                set.remove(str.charAt(x));
                x++;

            }

            set.add(str.charAt(i));

            max = Math.max(max, set.size());

        }

        return max;



          
    }
}