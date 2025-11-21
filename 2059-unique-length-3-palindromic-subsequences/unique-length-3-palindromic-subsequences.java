class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        HashMap<Character,Integer> firstOcc = new HashMap<Character,Integer>(); 
        HashMap<Character,Integer> lastOcc = new HashMap<Character,Integer>();
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            if(!firstOcc.containsKey(ch)){
                firstOcc.put(ch,i);
            }
            lastOcc.put(ch,i);
        }

        int count = 0;

        for(char ch : firstOcc.keySet()){
            int first = firstOcc.get(ch);
            int last = lastOcc.get(ch);

            if(first == last)continue;
            HashSet<Character> set = new HashSet<>();
            for(int i = first + 1; i<last; i++){
                set.add(s.charAt(i));
            }
            count = count + set.size();
        }
        return count;

    }
}