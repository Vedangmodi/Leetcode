class Solution {
    public int minEatingSpeed(int[] arr, int h) {

        int end = 0;

        for(int i=0; i<arr.length; i++){
            end = Math.max(end, arr[i]);

        }

        int start = 1;

        int ans = end;

        while(start <= end){
            int mid = start + (end - start)/2;

            long num = fun(arr, h, mid);

            // if(num == -1){
            //     start = mid + 1;
            //     continue;
            // }

            if(num > h){
                start = mid + 1;
            }
            else if(num <= h){
                end = mid - 1;

                if(ans > mid){
                    ans = mid;
                }
                
            }


        }

        return ans;
 
    }

    public long fun(int[] arr, int h, int x){
        long ans = 0;

        for(int i=0; i<arr.length; i++){
            // ans = ans + Math.ceil((double) arr[i]/x);
            ans += (arr[i] + x - 1) / x;

        }

        // if(ans > h){
        //     return -1;
        // }

        return ans;

    }
}