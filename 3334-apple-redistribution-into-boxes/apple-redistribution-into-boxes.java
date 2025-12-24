class Solution {
    public int minimumBoxes(int[] apple, int[] arr) {

        int sum = 0;

        for(int i = 0; i<apple.length; i++){
            sum += apple[i];

        }

        Arrays.sort(arr);

        int count = 0;
        int max = 0;

        for(int i = arr.length - 1; i>=0; i--){
            max = max + arr[i];
            count++;

            if(max >= sum){
                return count;
            }

        }

        return -1;
        
    }
}