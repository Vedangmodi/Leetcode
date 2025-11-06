class Solution {
    public int numSubarraysWithSum(int[] arr, int goal) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);

        int count = 0;
        int sum = 0;

        for(int i=0; i<arr.length; i++){
            sum = sum + arr[i];

            if(map.containsKey(sum - goal)){
                count = count + map.get(sum-goal);
            }

            map.put(sum, map.getOrDefault(sum,0) + 1);
        
        }

        return count;
        
    }
}