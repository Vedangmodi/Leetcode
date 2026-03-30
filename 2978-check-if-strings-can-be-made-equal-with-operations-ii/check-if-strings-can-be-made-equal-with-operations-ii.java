class Solution {
    public boolean checkStrings(String s1, String s2) {

        if(s1.length() != s2.length()){
            return false;
        }

        HashMap<Character, Integer> map1 = new HashMap<>();
        int len1 = 0;

        for(int i=0; i<s1.length(); i += 2){
            map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i), 0) + 1);
            len1++;
        }

        HashMap<Character, Integer> map2 = new HashMap<>();
        int len2 = 0;

        for(int i=0; i<s2.length(); i += 2){
            map2.put(s2.charAt(i), map2.getOrDefault(s2.charAt(i), 0) + 1);
            len2++;
        }

        if(!map1.equals(map2)){
            return false;
        }

        HashMap<Character, Integer> map3 = new HashMap<>();

        for(int i=1; i<s1.length(); i += 2){
            map3.put(s1.charAt(i), map3.getOrDefault(s1.charAt(i), 0) + 1);
        }

        HashMap<Character, Integer> map4 = new HashMap<>();

        for(int i=1; i<s2.length(); i += 2){
            map4.put(s2.charAt(i), map4.getOrDefault(s2.charAt(i), 0) + 1);
            
        }

        if(!map3.equals(map4)){
            return false;
        }

        return true;


        
    }
}