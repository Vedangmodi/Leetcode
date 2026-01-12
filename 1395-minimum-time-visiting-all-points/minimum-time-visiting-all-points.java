class Solution {
    public int minTimeToVisitAllPoints(int[][] arr) {
        int i = 0;
        int count = 0;

        while(i < arr.length - 1 ){
            int x = arr[i][0];
            int y = arr[i][1];

            int a = arr[i + 1][0];
            int b = arr[i + 1][1];

            int p = Math.abs(a - x);
            int q = Math.abs(b - y);

            int max = Math.max(p, q);

            count = count + max;
            i++;

        }
        return count;


        
    }
}