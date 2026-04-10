class Solution {
    public int minimumDistance(int[] arr) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for(int i=0; i<arr.length; i++){
            List<Integer> list = map.getOrDefault(arr[i], new ArrayList<Integer>());

            list.add(i);

            map.put(arr[i], list);

        }


        int max = Integer.MAX_VALUE;

        for(Map.Entry<Integer , List<Integer>> entry : map.entrySet()){
            List<Integer> list = entry.getValue();

            if(list.size() >= 3){
                for(int i=0; i<list.size()-2; i++){
                    int x = list.get(i);
                    int y = list.get(i+1);
                    int z = list.get(i+2);

                    int sum = Math.abs(x-y) + Math.abs(y-z) + Math.abs(z-x);

                    max = Math.min(max, sum);
                    
                }
            }
        }

        if(max == Integer.MAX_VALUE){
            return -1;
        }
        else{
            return max;
        }

        
        
    }
}