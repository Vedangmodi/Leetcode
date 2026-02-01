class Solution {
    public int minimumCost(int[] arr) {
        int min = arr[0] + arr[1] + arr[2];

        for(int i = 1; i<arr.length - 1; i++){
            for(int j = i+1; j < arr.length; j++){
                int x = arr[0] + arr[i] + arr[j];
                if(min > x){
                    min = x;
                }

            }
        }

        return min;
        
    }
}