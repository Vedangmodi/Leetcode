class Solution {
    public int minRemoval(int[] arr, int k) {
        Arrays.sort(arr);

        if(arr.length == 1){
            return 0;
        }

        int i = 1;
        int j = 0;

        int min = Integer.MAX_VALUE;

        while(i < arr.length){
            if((long) arr[j] * k >= arr[i]){
                
                min = Math.min(min, arr.length - (i - j + 1));
                i++;
            }
            else{
                j++;

            }
            
        }

        // if(i - j == arr.length){
        //     return 0;
        // }

        return min; 
    }
}
// 1 2 5