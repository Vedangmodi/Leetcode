class Solution {
    public int numOfSubarrays(int[] arr) {
        int mod = 1_000_000_007;
        int count = 0;
        int sum = 0;

        int even = 1;
        int odd = 0;

        for(int i=0; i<arr.length; i++){
            sum += arr[i];

            if(sum % 2 == 0){
                count += odd;
                even++;
            }
            else{
                count += even;
                odd++;
            }

            count = count % mod;
        }

        

        return count;
        
    }
}