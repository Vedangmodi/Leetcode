class Solution {
    public int totalMoney(int n) {
        int num = fun(n, 1, 1);
        return num;
        
    }

    public int fun(int n, int day, int sum){
        if(n == 0){
            return 0;
        }

        if(day % 7 == 1 && day > 1){ 
            sum = (day / 7) + 1;
        }
        
        return sum + fun(n-1, day + 1, sum + 1);

    }
}