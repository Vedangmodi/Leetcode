class Solution {
    public int nextBeautifulNumber(int n) {
        int x = 0;

        for(int i = n + 1; i<=1224444; i++){
            if(fun(i)){
                x = i;
                break;

            }

        }
        return x;
        
    }

    public boolean fun(int n){
        int[] arr = new int[10];

        while(n > 0){
            int x = n%10;
            arr[x]++;
            n = n/10;
        }

        for(int i=0; i<arr.length; i++){
            if(arr[i] == i || arr[i] == 0){
                continue;
            }
            else{
                return false;
            }
        }

        return true;
    }
}