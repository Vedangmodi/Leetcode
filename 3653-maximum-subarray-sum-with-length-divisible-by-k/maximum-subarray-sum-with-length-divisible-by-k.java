class Solution {
    public long maxSubarraySum(int[] arr, int k) {
        long[] nums = new long[arr.length];
        long s = 0;

        for(int i=0; i<arr.length; i++){
            s += arr[i];
            nums[i] = s;
        }

        long maxSum = Long.MIN_VALUE;

        for(int start=0; start<k; start++){
            long currSum = 0;
            int i = start;

            while(i < arr.length && i+k-1 < arr.length){
                int j = i+k-1;
                long subSum;

                if(i > 0){
                    subSum = nums[j] - nums[i - 1];
                }
                else{
                    subSum = nums[j];
                }

                currSum = Math.max(currSum + subSum, subSum);
                maxSum = Math.max(maxSum, currSum);

                i = i + k ;

            }
            
        }

        return maxSum;
        
    }
}


// -5, -4, -2, -5, -1