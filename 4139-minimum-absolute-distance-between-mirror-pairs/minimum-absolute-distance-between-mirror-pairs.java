class Solution {
    public int minMirrorPairDistance(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        

        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                min = Math.min(min, i - map.get(nums[i]));
            }

            map.put(rev(nums[i]), i);

        }

        return min == Integer.MAX_VALUE ? -1 : min;

        
    }

    public int rev(int num){
        int x = 0;

        while(num != 0){
            int a = num%10;
            x = x * 10 + a;
            num = num/10;
        }

        return x;
    }
}