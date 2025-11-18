class Solution {
    public boolean isOneBitCharacter(int[] arr) {
        int i=0;

        while(i < arr.length){
            if(arr[i] == 1 && i < arr.length - 1){
                i = i + 2;
            }
            else if(arr[i] == 0 && i == arr.length - 1){
                return true;
            }
            else if(arr[i] == 0){
                i++;
            }
        }

        return false;
        
    }
}