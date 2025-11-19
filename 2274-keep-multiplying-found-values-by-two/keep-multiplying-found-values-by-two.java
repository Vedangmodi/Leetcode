class Solution {
    public int findFinalValue(int[] nums, int original) {
        int n = nums.length;

        ArrayList<Integer> list = new ArrayList<>();

        int x = original;

        for(int i=0; i<nums.length; i++){
            list.add(nums[i]);
        }

        int j = 0;

        while(j < n){
            if(list.contains(x)){
                x = x * 2;
                j++;
            }
            else{
                break;
            }

        }

        return x;


        
    }
}