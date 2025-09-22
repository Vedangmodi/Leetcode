class Solution {
    public int maxFrequencyElements(int[] arr) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i],0) + 1);
        }

        int max = 0;
        for(int freq : map.values()){
            if(freq > max){
                max = freq;
            }
        }
        int count = 0;

        for(int x : map.values()){
            if(x == max){
                count = count + x;
            }
        }

        return count;



        
    }
}