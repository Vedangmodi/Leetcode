class Solution {
    public char nextGreatestLetter(char[] arr, char target) {
        int count = Integer.MAX_VALUE;
        char ch = arr[0];

        for(int i=0; i<arr.length; i++){
            if(arr[i] - target > 0 && count > arr[i] - target){
                count = arr[i] - target;
                ch = arr[i];
                
            }

        }

        return ch;
        
    }
}