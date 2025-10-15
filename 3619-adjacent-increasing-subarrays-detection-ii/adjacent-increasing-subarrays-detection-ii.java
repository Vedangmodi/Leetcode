class Solution {
    public int maxIncreasingSubarrays(List<Integer> list) {

        int k = 0;
        int curr = 1;
        int prev = 0;

        for(int i=0; i<list.size() - 1; i++){
            if(list.get(i) < list.get(i+1)){
                curr++;
               
            }
            else{ 
                prev = curr;
                curr = 1;
            }

            if(curr % 2 == 0){
                k = Math.max(curr/2, k);
            }

            k = Math.max(k, Math.min(prev, curr));
        }

        return k;
        
    }
}