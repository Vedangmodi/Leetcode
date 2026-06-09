class Solution {
    public long maxTotalValue(int[] arr, int k) {
        long max = Integer.MIN_VALUE;
        long min = Integer.MAX_VALUE;

        for(int i=0; i<arr.length; i++){
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
            
        }

        long x = max - min;

        return k * x;
       
        
    }
}