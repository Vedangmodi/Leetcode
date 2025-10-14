class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> list, int k) {
        int count = 1;
        
        for(int i=0; i<=list.size() - k * 2; i++){
            if(fun(list , i, i+k-1) && fun(list,i+k, i + k * 2 - 1)){
                return true;
            }
            
        }

        return false;
        
    }

    public boolean fun(List<Integer> list, int i, int j){
        while(i < j){
            if(list.get(i) < list.get(i + 1)){
                i++;
                
            }
            else{
                return false;
            }
        }

        return true;

    }
}