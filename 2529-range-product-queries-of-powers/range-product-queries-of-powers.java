class Solution {
    public int[] productQueries(int n, int[][] queries) {
        int mod = 1000000007;

        List<Integer> list = new ArrayList<>();
         for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
            list.add(1 << i);
          }
        }
// nums[i] = (int) Math.pow(2,i);

        int a = queries.length;

        int[] arr = new int[a];

        for(int i=0; i<a; i++){
            arr[i] = 1;
            long product = 1;
            for(int j=queries[i][0]; j<=queries[i][1]; j++){
                product = (product * list.get(j)) % mod;

            }
            arr[i] = (int) product;
            
        }

        return arr;


        
    }
}