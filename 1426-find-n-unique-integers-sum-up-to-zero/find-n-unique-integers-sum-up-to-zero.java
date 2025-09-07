class Solution {
    public int[] sumZero(int n) {
        int[] arr = new int[n];

        boolean flag = false;

        if(n%2 != 0){
            flag = true;
        }
        else{
            flag = false;
        }

        int x = n/2;

        for(int i=0; i<=x; i++){
            if(flag){
                arr[i] = -1 * i;
            }
            else if(i != x){
                arr[i] = -1 * (i + 1);
            }
        }

        int num = 1;

        if(flag){
            for(int i=x+1; i<n; i++){
            arr[i] = num;
            num++;
           }
        }
        else{
            for(int i=x; i<n; i++){
            arr[i] = num;
            num++;

         }
        }

        

        



        return arr;
        
    }
}