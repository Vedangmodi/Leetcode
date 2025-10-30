class Solution {
    public int minNumberOperations(int[] target) {
        int[] arr = new int[target.length];
        int count = 0;
        int curr = 0;
        int prev = 0;

        for(int i=0; i<arr.length; i++){
            curr = target[i];

            if(curr > prev){
                count = count + (curr - prev);
            }

            prev = curr;

        }

        return count;
        
    }
}