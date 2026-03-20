class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] arr = new int[m-k+1][n-k+1];

        for(int i=0; i<m-k+1; i++){
            for(int j=0; j<n-k+1; j++){
                TreeSet<Integer> set = new TreeSet<>();

                fun(grid, k, set, i, j);

                int min = Integer.MAX_VALUE;
                Integer prev = null;

                for(Integer curr : set){
                    if(prev != null){
                        int diff = curr - prev;

                        min = Math.min(min, diff);
                    }
                    prev = curr;
                }

                if(set.size() <= 1){
                    arr[i][j] = 0;
                }
                else{
                    arr[i][j] = min;
                }
            }
        } 

        return arr;  
    }

    public void fun(int[][] grid, int k, TreeSet<Integer> set, int a, int b){
        for(int i=a; i<k + a; i++){
            for(int j=b; j<k + b; j++){
                set.add(grid[i][j]);
            }
        }
    }
}