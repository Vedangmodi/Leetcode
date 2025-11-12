class Solution {
    public int minOperations(int[] arr) {
        int count1 = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] == 1){
                count1++;
            }
        }

        if(count1 > 0){
            return arr.length - count1;
        }

        int count = Integer.MAX_VALUE;

        for(int i=0; i<arr.length; i++){
            int val = arr[i];
            for(int j=i+1; j<arr.length; j++){
                val = gcd(val, arr[j]);

                if(val == 1){
                    count = Math.min(count, j - i);
                    break;
                }
            }

        }

        if(count == Integer.MAX_VALUE){
            return -1;
        }
        else {
            return count + arr.length - 1;

        }

        
    }

    public int gcd(int a, int b){
        while(b != 0){
            int temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }
}