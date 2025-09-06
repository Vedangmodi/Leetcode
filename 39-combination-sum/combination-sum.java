class Solution {
    public List<List<Integer>> combinationSum(int[] arr, int target) {

        List<List<Integer>> ans = new ArrayList<>();

        ArrayList<Integer> ds = new ArrayList<>();

        fun(0, arr, target, ds, ans);
        return ans;
        
    }

    public void fun(int idx, int[] arr, int target, ArrayList<Integer> ds, List<List<Integer>>ans){
        if(idx == arr.length){
            if(target == 0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }

        if(target >= arr[idx]){
            ds.add(arr[idx]);
            fun(idx, arr, target - arr[idx], ds, ans);
            ds.remove(ds.size() - 1);
        }
        
        fun(idx + 1, arr, target, ds, ans);
        

    }
}