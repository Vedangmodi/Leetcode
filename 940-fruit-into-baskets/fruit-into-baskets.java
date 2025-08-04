class Solution {
    public int totalFruit(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int count = 0;
        int sum = 0;
        int k = 0;

        for(int i=0; i<arr.length; i++){

            map.put(arr[i],map.getOrDefault(arr[i],0) + 1);

            while(map.size() > 2){
                map.put(arr[k], map.get(arr[k]) - 1);
                if(map.get(arr[k]) == 0){
                    map.remove(arr[k]);
                    
                }
                k++;
            }
            count = Math.max(count , i-k+1) ;
                

        }
        return count;
        
    }
}