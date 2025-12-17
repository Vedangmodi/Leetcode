class Solution {
    public boolean carPooling(int[][] arr, int capacity) {

        int max = Integer.MIN_VALUE;

		for(int i=0; i<arr.length; i++){
			int x = arr[i][2];

			max = Math.max(max, x);
		}

		int[] nums = new int[max + 1];

		for(int i=0; i<arr.length; i++){
			int people = arr[i][0];
			int x = arr[i][1];
			int y = arr[i][2];

			nums[x] = nums[x] + people;

			if(y < max){
				nums[y] = nums[y] - people; 
			}
		}

		for(int i=1; i<nums.length; i++){
			nums[i] = nums[i] + nums[i-1];

		}

		for(int i = 0;i<nums.length; i++){
			if(nums[i] > capacity){
				return false;
			}
		}

		return true;
 
    }
}