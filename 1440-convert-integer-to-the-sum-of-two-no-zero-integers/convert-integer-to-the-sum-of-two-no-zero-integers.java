class Solution {
    public int[] getNoZeroIntegers(int n) {
        int[] arr = new int[2];

        for(int i=1; i<n ; i++){
            int p = i;
            int q = n - i;
            int x = n - i;
            

            boolean flag1 = true;
            boolean flag2 = true;

            while(p > 0){
                int a = p % 10;
                if(a == 0){
                    flag1 = false;
                    break;      
                }else{
                    p = p/10;
                }
            }

            while(x > 0){
                int a = x % 10;
                if(a == 0){
                    flag2 = false;
                    break;      
                }else{
                    x = x/10;
                }
            }

            if(flag1 && flag2){
                arr[0] = i;
                arr[1] = q;
                break;
            }
            else{
                continue;
            }


        }
        return arr;
        
    }
}