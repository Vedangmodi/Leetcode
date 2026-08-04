class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);

        ArrayList<Integer> list = new ArrayList<>();

        int x = nums[0];
        int i = 0;

        while(x < nums[nums.length - 1]){
            if(nums[i] == x){
                i++;
                x++;
            }
            else{
                list.add(x);
                x++;
            }

        }

        return list;
        
    }
}