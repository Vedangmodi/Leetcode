class Solution {
    public String minWindow(String str, String t) {

        int n = str.length();
        int a = t.length();

        if(n < a){
            return new String("");
        }

        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        for(int i=0; i<a; i++){
            map2.put(t.charAt(i), map2.getOrDefault(t.charAt(i), 0) + 1);
        }

        int p = 0;
        int q = Integer.MAX_VALUE;

        int j = 0;

        for(int i=0; i<n; i++){
            char ch = str.charAt(i);

            map.put(ch, map.getOrDefault(ch ,0) + 1);

            if(!isValid(map, map2)){
                continue;
            }
            else{
                while(isValid(map, map2)){
                    if(i - j < q - p){
                        p = j;
                        q = i;
                    }

                    char c = str.charAt(j);

                    if(map.get(c) > 1){
                        map.put(c, map.getOrDefault(c, 0) - 1);
                    }
                    else{
                        map.remove(c);
                    }

                    j++;
                }
            }
        }

        if(q == Integer.MAX_VALUE){
            return new String("");
        }


        return str.substring(p, q+1);

        
    }

    public boolean isValid(HashMap<Character, Integer> map, HashMap<Character, Integer> map2){
        for(char ch : map2.keySet()){
            if(!map.containsKey(ch)){
                return false;
            }
            else if(map.get(ch) < map2.get(ch)){
                return false;
            }
        }

        return true;

    }
}