class Solution {
    static int M =(int) 1e9 + 7;
    public int specialTriplets(int[] arr) {

        HashMap<Integer, Integer> mapr = new HashMap<>();

        for(int i=0; i<arr.length; i++){
            mapr.put(arr[i], mapr.getOrDefault(arr[i], 0) + 1);

        }

        int count = 0;

        HashMap<Integer, Integer> mapl = new HashMap<>();

        for(int i=0; i<arr.length; i++){
            if(mapr.get(arr[i]) == 1){
                mapr.remove(arr[i]);
            }
            else {
                mapr.put(arr[i], mapr.getOrDefault(arr[i], 0) - 1);

            }

            int x = mapl.getOrDefault(arr[i] * 2, 0);
            int y = mapr.getOrDefault(arr[i] * 2, 0);

            // if(mapl.containsKey(arr[i] * 2) && mapr.containsKey(arr[i] * 2)){
            long add = ((long)x * y) % M;
            count = (int)(count + add)%M;
            // }
          
            mapl.put(arr[i], mapl.getOrDefault(arr[i], 0) + 1);

        

        }

        return count % 1000000007;
        
    }
}

