class Solution {
    public int longestBalanced(int[] arr) {

        int max = 0;

        for(int i=0; i<arr.length; i++){

            HashSet<Integer> oset = new HashSet<>();
            HashSet<Integer> eset = new HashSet<>();

            for(int j=i; j<arr.length; j++){
                if(arr[j] % 2 == 0){
                    eset.add(arr[j]);
                }
                else {
                    oset.add(arr[j]);
                }

                if(oset.size() == eset.size()){
                    max = Math.max(max, j - i + 1);
                }
            }

        }

        return max;
        
    }
}


// optimised code - but misses some test cases, so this is wrong for this problem, there is no optimisation here so there is O(n²) only. 

// so thsi sol is wrong.


// class Solution {
//     public int longestBalanced(int[] nums) {
//         HashSet<Integer> evenSet = new HashSet<>();
//         HashSet<Integer> oddSet = new HashSet<>();
//         HashMap<Integer, Integer> diffIndex = new HashMap<>();

//         diffIndex.put(0, -1); // base case: balance before array starts
//         int ans = 0;
//         int diff = 0;

//         for (int i = 0; i < nums.length; i++) {
//             int val = nums[i];

//             if (val % 2 == 0) evenSet.add(val);
//             else oddSet.add(val);

//             diff = evenSet.size() - oddSet.size();

//             if (diffIndex.containsKey(diff)) {
//                 ans = Math.max(ans, i - diffIndex.get(diff));
//             } else {
//                 diffIndex.put(diff, i);
//             }
//         }

//         return ans;
//     }
// }
