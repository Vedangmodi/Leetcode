class Solution {
    int m, n;
    public int getMaximumGold(int[][] arr) {
        m = arr.length;
        n = arr[0].length;
        int maxGold = 0;
        for(int i=0;i<m; i++){
            for(int j=0; j<n; j++){
                if(arr[i][j] != 0){
                    maxGold = Math.max(maxGold,dfs(arr, i, j));

                }
            }

        }
        return maxGold;
        
    }

    int[][] dir = {{-1,0}, {1,0}, {0,1}, {0,-1}};

    public int dfs(int[][] arr, int i, int j){
        if(i >= m || j >= n || i < 0 || j < 0 || arr[i][j] == 0){
            return 0;
        }

        int num = arr[i][j];
        arr[i][j] = 0;

        int maxGold = 0;

        for(int[] x : dir){
            int a = i + x[0];
            int b = j + x[1];

            maxGold = Math.max(maxGold, dfs(arr, a, b));
        }

        arr[i][j] = num;
        return num + maxGold;


    }
}