class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);

        int abs = Integer.MAX_VALUE;

        for(int i = 1; i<arr.length; i++){
            abs = Math.min(abs, Math.abs(arr[i] - arr[i-1]));
        }

        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 1; i<arr.length; i++){
            List<Integer> list = new ArrayList<>();

            if(Math.abs(arr[i] - arr[i-1]) == abs){
                list.add(arr[i-1]);
                list.add(arr[i]);

                ans.add(list);
            }
        }

        return ans;


        
    }
}