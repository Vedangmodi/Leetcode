class Solution {
    public int minElement(int[] nums) {

        int min = Integer.MAX_VALUE;

        for(int i=0; i<nums.length; i++){
            int x = fun(nums[i]);

            min = Math.min(min, x);

        }

        return min;
        
    }

    public int fun(int num){
        int x = 0;

        while(num > 0){
            x += num%10;
            num = num/10;
        }

        return x;
    }
}