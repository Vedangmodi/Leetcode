class Solution {
    public boolean reorderedPowerOf2(int n) {

        HashMap<Integer,Integer> map = new HashMap<>();
        int count = 0;

        while(n > 0){
            int num = n % 10;
            n = n/10;
            count++;

            map.put(num, map.getOrDefault(num,0) + 1);
        }


        int a = 1;

        for(int i=0; i<=30; i++){
            HashMap<Integer,Integer> temp = new HashMap<>();
            int x = a;
            

            while(x > 0){
                int num = x % 10;
                x = x/10;

                temp.put(num, temp.getOrDefault(num,0) + 1);

            }

            if(map.equals(temp)){
                return true;
            }
            else{
                a = a*2;
            }
        }

        return false;
    }
}