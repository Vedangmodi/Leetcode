class Solution {
    public int numberOfSubarrays(int[] nums, int k) {

        int[] arr = new int[nums.length];

        for(int i=0; i<nums.length; i++){
            if(nums[i] % 2 == 0){
                arr[i] = 0;
            }
            else{
                arr[i] = 1;
            }
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);

        int count = 0;
        int sum = 0;
        
        for(int i=0; i<arr.length; i++){
            sum = sum + arr[i];

            if(map.containsKey(sum - k)){
                count = count + map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum,0) + 1);

        }
        return count;
        
    }
}