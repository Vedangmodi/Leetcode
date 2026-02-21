class Solution {
    public int countPrimeSetBits(int left, int right) {

        int count = 0;

        for(int i = left; i<= right; i++){
            int bits = setBits(i);

            boolean prime = isPrime(bits);

            if(prime == true){
                count++;
            }

        }

        return count;
        
    }

    public int setBits(int num){
        int count = 0;

        while(num > 0){
            num = num & (num - 1);
            count++;
        }
        return count;
    }

    public boolean isPrime(int num){
        if(num <= 1){
            return false;
        }

        int c = 2;

        while(c * c <= num){
            if(num % c == 0){
                return false;
            }
            c++;
        }

        return true;
    }
}

// 1000000