class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        
        // int[] arr = new int[nums.length];

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for(int i=0; i<nums.length; i++){
            sum = sum + nums[i];
            int rem = sum % k;

            if(sum < 0){
                rem = (rem + k) % k;
            }

            if(map.containsKey(rem)){
                count += map.get(rem);
            }

            map.put(rem, map.getOrDefault(rem, 0) + 1);


        }

        return count;
    }
}