class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;

        int[] arr = new int[n];

        TreeSet<Integer> set = new TreeSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<rains.length; i++){
            if(rains[i] == 0){
                set.add(i);          
            }
            else{
                arr[i] = -1;

                if(map.containsKey(rains[i])){
                    // Get the last day when this lake was filled
                    int lastday = map.get(rains[i]);

                    // Find a dry day after that day to dry it before it rains again
                    Integer dryday = set.higher(lastday);

                    if(dryday == null){
                        return new int[0];
                    }

                    arr[dryday] = rains[i];
                    set.remove(dryday);

                }
                map.put(rains[i], i);
            }
        }

        for(int x : set){
            arr[x] = 1;
        }

        return arr;

    }
}