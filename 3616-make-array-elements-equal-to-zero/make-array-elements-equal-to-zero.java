class Solution {
    public int countValidSelections(int[] arr) {
        int sum = 0;

        for(int i : arr){
            sum += i;
        }

        int lsum = 0;
        int count = 0;

        for(int i=0; i<arr.length; i++){
            lsum += arr[i];
            sum = sum - arr[i];

            if(arr[i] == 0){
                if(lsum == sum){
                    count = count + 2;
                }
                else if(lsum == sum + 1 || lsum + 1 == sum){
                    count++;
                }
            }

        }

        return count;


        
    }
}