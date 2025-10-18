class Solution {
    public int maxDistinctElements(int[] arr, int k) {
        Arrays.sort(arr);
        int prev = Integer.MIN_VALUE;;
        int count = 0;

        for(int n : arr){
           
            if(prev < n - k){
                prev = n - k;
                count++;
            }
            else if(prev < n + k){
                prev += 1;
                count++;
            }

        }
        return count;
    }
}