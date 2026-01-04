class Solution {
    public int sumFourDivisors(int[] arr) {
        int sum = 0;

        for(int i=0; i<arr.length; i++){
            int x = sqrt(arr[i]);
            sum = sum + x;

        }

        return sum;
        
    }

    public int sqrt(int n){
        
        int count = 0;
        int sum = 0;
        for(int i=1; i*i <= n; i++){
            if(n % i == 0){
                if(i * i == n){
                    sum = sum + i;
                    count++;
                }
                else{
                    sum = sum + i + (n/i);
                    count = count + 2;

                }   
            }
        }

        if(count == 4){
            return sum;
        }
        return 0;
    }
}