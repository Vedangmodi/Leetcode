class Solution {
    public int minSubarray(int[] arr, int p) {
        int csum = 0;

        for(int i = 0; i<arr.length; i++){
            csum = (csum + arr[i]) % p;

        }

        if(csum % p == 0){
            return 0;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        // int j = 0;

        int ans = Integer.MAX_VALUE;
        int curr = 0;
        int rem = csum % p;

        for(int i = 0; i<arr.length; i++){
            curr = (curr + arr[i]) % p;

            int a = (curr - rem + p) % p;

            if(!map.containsKey(a)){
                map.put(curr, i);

            }
            else{
                ans = Math.min(ans, i - map.get(a));
                map.put(curr,i);
            }
        }

        if(ans == arr.length){
            return -1;
        }
        return ans;     
    }
}