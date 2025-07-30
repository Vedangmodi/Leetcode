class Solution {
    public long countPairs(int[] arr, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0; i<arr.length; i++){
            int a = gcd(arr[i], k);
            map.put(a,map.getOrDefault(a,0) + 1);
        }  

        long count = 0;

        for(int i : map.keySet()){
            for(int j : map.keySet()){
                if((long) i * j % k == 0){
                    
                    if(i == j){
                        int freq = map.get(i);
                        count +=  ((long)  freq) * (freq - 1)/2;

                    }
                    else if(i < j) {
                        count += ((long) map.get(i) ) * map.get(j);
                    }

                }
            }
        }
        return count;
        
    }

    public int gcd(int a,int b){
        if(b == 0){
            return a;
        }
        return gcd(b, a%b);
    }
}