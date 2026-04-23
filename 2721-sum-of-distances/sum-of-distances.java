class Solution {
    public long[] distance(int[] nums) {
        HashMap<Integer, Long> mapSum = new HashMap<>();
        HashMap<Integer, Long> mapCount = new HashMap<>();

        long[] arr = new long[nums.length];

        for(int i=0; i<nums.length; i++){
           Long sum = mapSum.getOrDefault(nums[i], 0L);
           Long freq = mapCount.getOrDefault(nums[i], 0L);

           arr[i] += freq * i - sum;

           mapSum.put(nums[i], sum + i);
           mapCount.put(nums[i], freq + 1);
        }

        mapSum.clear();
        mapCount.clear();

        for(int i=nums.length - 1; i>=0; i--){
            Long sum = mapSum.getOrDefault(nums[i], 0L);
            Long freq = mapCount.getOrDefault(nums[i], 0L);

            arr[i] += sum - freq * i;

            mapSum.put(nums[i], sum + i);
            mapCount.put(nums[i], freq + 1);



        }

        return arr;
        
    }
}