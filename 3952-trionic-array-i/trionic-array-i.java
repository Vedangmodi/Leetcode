class Solution {
    public boolean isTrionic(int[] arr) {

        boolean first = false;
        boolean second = false;
        boolean third = false;

        int i = 0;

        while(i < arr.length - 1 && arr[i]  < arr[i + 1]){
            i++;
            first = true;
        }

        if(i == arr.length - 1){
            return false;
        }

        while(i < arr.length - 1 && arr[i] > arr[i + 1]){
            i++;
            second = true;
        }

        if(i == arr.length - 1){
            return false;
        }

        while(i < arr.length - 1 && arr[i]  < arr[i + 1]){
            i++;
            third = true;
        }

        if(i == arr.length - 1 && first && second && third){
            return true;
        }

        return false;

        
    }
}