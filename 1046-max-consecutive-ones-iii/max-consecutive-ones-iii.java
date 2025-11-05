class Solution {
    public int longestOnes(int[] arr, int k) {
        
        int max = 0;

        int j = 0;
        int z = 0;

        for(int i=0; i<arr.length; i++){
            if(arr[i] == 0){
                z++;   
            }
                // j = i - k + 1;
                
            while(z > k && j <= i){
                if(arr[j] == 0){
                    z--;
                    j++;    
    
                }
                else{
                    j++;
                }
            }

            max = Math.max(max, i-j+1);

        }

        return max;
        
    }
}