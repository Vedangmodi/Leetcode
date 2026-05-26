class Solution {
    public int numberOfSpecialChars(String str) {
        Set<Character> set = new HashSet<>();

        for(int i=0; i<str.length(); i++){
            set.add(str.charAt(i));
        }

        int count = 0;

        for(int i = 0; i<26; i++){
            char lower = (char)('a' + i);
            char upper = (char)('A' + i);
            if(set.contains(lower) && set.contains(upper)){
                count++;
            }

        }

        return count;
        
    }
}