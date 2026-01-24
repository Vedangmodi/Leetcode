class Solution {
    public int minPairSum(int[] arr) {
        Arrays.sort(arr);

        int max = 0;

        int i = 0;
        int j = arr.length - 1;

        while(i < j){
            if((long) arr[i] + arr[j] > max){
                max = arr[i] + arr[j];
            }

            i++;
            j--;

        }

        return max;

        
    }
}

