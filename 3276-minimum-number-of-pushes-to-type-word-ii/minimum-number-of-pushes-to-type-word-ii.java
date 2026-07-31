class Solution {
    public int minimumPushes(String word) {
        
        HashMap<Character,Integer> map = new HashMap<>();
        char[] arr = word.toCharArray();

        for(int i=0; i<arr.length; i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i])+1);
            }
            else{
                map.put(arr[i],1);
            }
        }

        // if(map.size() <= 8){
        //     int cost = 0;
        //     for(char a : map.keySet()){
        //         cost = cost + map.get(a);
        //     }
        //     return cost;
        // }
        // else{
        // }

        ArrayList<Integer> freq = new ArrayList<>(map.values());
        Collections.sort(freq,Collections.reverseOrder());
        
        int cost = 0;
        int multiply = 1;

        for(int i=0; i<freq.size(); i++){
            if(i>0 && i%8 == 0){
                multiply++;
            }
            cost = cost + freq.get(i) * multiply;
        }
        return cost;     
    }
}