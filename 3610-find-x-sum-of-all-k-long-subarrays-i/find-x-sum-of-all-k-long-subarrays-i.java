class Solution {
    public int[] findXSum(int[] nums, int k, int x) {

        int[] ans = new int[nums.length - k + 1];
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<=nums.length - k; i++){
            
            for(int j=i; j<i+k; j++){
                map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            }

            List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());

            list.sort((a,b) -> {
                if(!a.getValue().equals(b.getValue())){
                    return b.getValue() - a.getValue();
                }
                else {
                    return b.getKey() - a.getKey();
                }
            } );

            int sum = 0;
            for (int t = 0; t < Math.min(x, list.size()); t++) {
                int num = list.get(t).getKey();
                int freq = list.get(t).getValue();
                sum += num * freq;
            }

            ans[i] = sum;
            map.clear();


        }

        return ans;
        
    }
}