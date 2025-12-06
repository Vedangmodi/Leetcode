class Solution {
    public void sortColors(int[] arr) {
        
        for(int i=0; i<arr.length - 1; i++){
            for(int j=i + 1; j<arr.length ; j++){
                if(arr[i] > arr[j]){
                    swap(arr,i,j);
                }
            }
        }
        
    }

    public void swap(int[] arr,int x,int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp; 
    }
}