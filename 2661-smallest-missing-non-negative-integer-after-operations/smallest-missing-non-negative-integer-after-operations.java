class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int n = nums.length;
        int[] arr = new int[value];

        for(int i=0; i<n; i++){
           
            int x = ((nums[i] % value) + value) % value;
               
            arr[x]++;
        } 

        for(int i=0; i<arr.length; i++){
            if(arr[i] == 0){
                return i;
            }
        }

        int minIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[minIndex]) {
                minIndex = i;
            } 
        }
        return arr[minIndex] * value + minIndex;
    }
}