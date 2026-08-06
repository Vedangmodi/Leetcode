class Solution {
    public int smallestNumber(int n, int t) {
        int num = n;

        while(num < 101){
            int x = fun(num);

            if(x % t == 0){
                return num;
            }
            num++;

        }

        return 0;
        
    }

    public int fun(int n){
        int x = 1;

        while(n > 0){
            int a = n % 10;
            x = x * a;
            n = n/10;
        }

        return x;
    }
}