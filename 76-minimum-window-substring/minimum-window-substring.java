class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> maps = new HashMap<>();
        HashMap<Character, Integer> mapt = new HashMap<>();

        for(int i=0; i<t.length(); i++){
            char ch = t.charAt(i);
            mapt.put(ch, mapt.getOrDefault(ch, 0) + 1);
        }

        int j = 0;

        int a = 0;
        int b = Integer.MAX_VALUE; 

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            maps.put(ch, maps.getOrDefault(ch, 0) + 1);

            if(!isValid(maps, mapt)){
                continue;
                
            }
            
            while(isValid(maps, mapt)){
                if(b - a > i - j){
                    a = j;
                    b = i;
                }

                char c = s.charAt(j);

                if(maps.get(c) > 1){
                    maps.put(c, maps.getOrDefault(c,0) - 1);
                }
                else{
                    maps.remove(c);
                }
                j++;
            }
            
        }

        if (b == Integer.MAX_VALUE) return "";

        StringBuilder sb = new StringBuilder();

        for(int i=a; i<=b; i++){
            sb.append(s.charAt(i));

        }

        return sb.toString();
        
    }

    public boolean isValid(HashMap<Character, Integer> maps, HashMap<Character, Integer> mapt){
        for(Character ch : mapt.keySet()){
            if(!maps.containsKey(ch)){
                return false;
            }
            else if(mapt.get(ch) > maps.get(ch)){
                return false;
            }
        }

        return true;

    }
}