class Solution {
    public List<Integer> solveQueries(int[] nums, int[] q) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        int n = nums.length;

        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                ArrayList<Integer> list = map.get(nums[i]);
                list.add(i);
            }
            else{
                map.put(nums[i], new ArrayList<Integer>());
                ArrayList<Integer> list = map.get(nums[i]);
                list.add(i);
            }
            
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=0; i<q.length; i++){
            int num = nums[q[i]];
            
            List<Integer> list = map.get(num);

            if(list.size() == 1){
                ans.add(-1);
                continue;
            }

            else{
                int pos = Collections.binarySearch(list, q[i]);

                int leftidx = (pos - 1 + list.size()) % list.size();
                int rightidx = (pos + 1) % list.size();

                int left = list.get(leftidx);
                int right = list.get(rightidx);
                int curr = list.get(pos);

                int d1 = Math.min(Math.abs(curr - left), n - Math.abs(curr - left));
                int d2 = Math.min(Math.abs(curr - right), n - Math.abs(curr - right));

                ans.add(Math.min(d1, d2));
            }

            

        }

        return ans;
        
    }
}