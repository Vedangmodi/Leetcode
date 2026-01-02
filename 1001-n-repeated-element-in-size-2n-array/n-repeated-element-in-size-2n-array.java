class Solution {
    public int repeatedNTimes(int[] arr) {
        int n = arr.length / 2;

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

            int x = map.get(arr[i]);

            if(x == n){
                return arr[i];
            }

        }

        return -1;  
        
    }
}