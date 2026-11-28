class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        int[] arr = new int[n - k + 1];
        int idx = 0;

        Deque<Integer> dq = new ArrayDeque<>();

        for(int i=0; i<n; i++){

            while(!dq.isEmpty() && nums[i] > nums[dq.peekLast()]){
                dq.pollLast();
            }

            dq.addLast(i);


            // while(nums[dq.peekLast()] > nums[dq.peekFirst()]){
            //     dq.pollFirst();
            // }

            while(dq.peekFirst() < i - k + 1){
                dq.pollFirst();
            }

            if(i - k + 1 >= 0){
                arr[i - k + 1] = nums[dq.peekFirst()];

            }

        }

        return arr;


    }
}