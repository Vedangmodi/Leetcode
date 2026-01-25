class Solution {
    public int minimumDifference(int[] arr, int k) {
        Arrays.sort(arr);

        int i = 0;
        int j = i+k-1;

        int count = Integer.MAX_VALUE;

        while(j < arr.length){
            int a = arr[i];
            int b = arr[j];

            count = Math.min(count, b - a);

            i++;
            j++;

        }

        return count;
    }
}