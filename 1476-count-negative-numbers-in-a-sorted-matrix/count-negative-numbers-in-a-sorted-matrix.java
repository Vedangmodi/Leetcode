class Solution {
    public int countNegatives(int[][] arr) {
        int count = 0;
        for(int i=0; i<arr.length; i++){
        int start = 0;
        int end = arr[0].length - 1;
        
        while(start<=end){   
                int mid = start + (end - start)/2;
            if(arr[i][mid] >= 0){
                start = mid + 1;
            }
            else{
                count = count +(end - mid + 1);
                end = mid - 1;
               
            }
            }  
        }
        return count;
    }
}