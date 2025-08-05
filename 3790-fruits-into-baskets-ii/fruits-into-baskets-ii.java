class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int[] arr = Arrays.copyOf(baskets, baskets.length);
        int count = 0;

        for(int i=0; i<fruits.length; i++){
            
            for(int j=0; j<arr.length; j++){
                if(fruits[i] <= arr[j]){
                    arr[j] = 0;
                    count++;
                    break;
                }
            }
        }

        return fruits.length - count;

        
    }
}