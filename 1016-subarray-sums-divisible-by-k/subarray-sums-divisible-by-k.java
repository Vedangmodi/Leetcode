class Solution {
    public int subarraysDivByK(int[] arr, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int result = 0;
        int sum = 0;
        map.put(0,1);

        for(int i = 0; i<arr.length; i++){
            int rem = 0;
            sum = sum + arr[i];

            if(sum >= 0){
                rem = sum % k;
            }
            else if(sum < 0){
                int s1 = sum;
                while(s1 < 0){
                    s1 = s1 + k;
                }
                rem = s1 % k;
            }

            if(!map.containsKey(rem)){
                map.put(rem,1);
            }
            else if(map.containsKey(rem)){
                result = result + map.get(rem);
                map.put(rem,map.get(rem) + 1);
            }
        }

        return result;

        
    }
}