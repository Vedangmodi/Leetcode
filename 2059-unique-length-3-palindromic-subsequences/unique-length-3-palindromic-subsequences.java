class Solution {
    public int countPalindromicSubsequence(String str) {

        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        for(int i=0; i<str.length(); i++){
            if(!map1.containsKey(str.charAt(i))){

                map1.put(str.charAt(i), i);
                map2.put(str.charAt(i), i);
            }

            // if(map2.contains(str.charAt(i)))
            else {
                map2.put(str.charAt(i), i);
            }

        }


        int count = 0;

        for(char ch : map1.keySet()){
            int x = map1.get(ch);
            int y = map2.get(ch);

            HashSet<Character> set = new HashSet();

            for(int i = x + 1; i<y; i++){
                set.add(str.charAt(i));

            }

            count = count + set.size();
        }

        return count;


        

    }
}