class Solution {
    public int minCost(String str, int[] arr){
        int count = 0;

        int i=0;
        int j=1;

        while(j<arr.length){
            if(str.charAt(i) == str.charAt(j)){
                count = count + Math.min(arr[i], arr[j]);

                if(arr[i] < arr[j]){
                    i = j;
                }
                
            }
            else{
                i = j;
            }
            j++;   
        }

        return count;
    }
}


