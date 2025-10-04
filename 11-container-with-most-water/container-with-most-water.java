class Solution {
    public int maxArea(int[] arr) {
        int i=0;
        int j=arr.length - 1;
        int max = 0;

        while(i < j){
            int x = j - i;
            int y = Math.min(arr[i], arr[j]);

            max = Math.max(max,(x*y));

            if(arr[i] > arr[j]){
                j--;
            }
            else{
                i++;
            }
            
        }
        return max;
        
    }
}