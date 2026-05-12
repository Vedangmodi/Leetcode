class Solution {

    public boolean isPossible(int[][] tasks, int mid) {

        for(int[] task : tasks) {
            int actual  = task[0];
            int minimum = task[1];

            if(minimum > mid) {
                return false;
            }

            mid -= actual;
        }

        return true;
    }

    public int minimumEffort(int[][] tasks) {

        int n = tasks.length;

        int l = 0;
        int r = (int)1e9;

        int result = Integer.MAX_VALUE;

        Arrays.sort(tasks, (task1, task2) -> {
            int diff1 = task1[1] - task1[0];
            int diff2 = task2[1] - task2[0];

            return diff2 - diff1;
        });

        while(l <= r) {

            int mid = l + (r-l)/2;

            if(isPossible(tasks, mid)) {
                result = mid;
                r = mid-1;
            } else {
                l = mid+1;
            }
        }

        return result;
    }

    
    // public int minimumEffort(int[][] tasks) {

        // int n = tasks.length;

        // long sum0 = 0;
        // long sum1 = 0;
        // long max = Long.MIN_VALUE;

        // for(int i=0; i<n; i++){
        //     int a = tasks[i][0];
        //     int b = tasks[i][1];

        //     max = Math.max(max, b);
        //     sum0 += a;
        //     sum1 += b;
        // }

        // long ans = binary(max, sum0, sum1);
        // return (int)ans;
 
    // }

    // public long binary(long max, long sum0, long sum1){
    //     long start = max;
    //     long end = sum1;
    //     long num = 0;
    //     while(start <= end){
    //         long mid = start + (end - start)/2;

    //         if(sum0 - mid <= 0){
    //             end = mid - 1;
    //         }
    //         else if(sum0 - mid > 0){
    //             num = mid;
    //             start = mid + 1;
    //         }

    //     }
    //     return num;
    // }
}

// [5,11]