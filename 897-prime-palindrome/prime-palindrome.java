// question that needs to rule out all 8-digit numbers ......
class Solution {
    public int primePalindrome(int n) {
        while(true){
            if(n == reverse(n) && prime(n)){
                return n;
            
            }
            n++;

            if(10000000 < n && n < 100000000){
                n = 100000000;
            }
            
        }
        
        
    }

    public boolean prime(int n){
        if(n < 2){
            return false;
        }

        int a = 2;

        while(a * a <= n){
            if(n % a == 0){
                return false;
            }
            a++;
        }
        return true;

    }

    public int reverse(int n){
        int a = 0;

        while(n > 0){
            a = a * 10 + (n%10);
            n = n/10;
        }
        return a;
    }
}