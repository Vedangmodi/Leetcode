class Solution {
    int[] parent;
    int[] rank;

    public int find(int x){
        if(parent[x] == x){
            return x;
        }

        return parent[x] = find(parent[x]);

    }

    public void union(int x, int y){
        int px = find(x);
        int py = find(y);

        if(px == py){
            return;
        }

        if(rank[px] < rank[py]){
            parent[px] = py;

        }
        else if(rank[py] < rank[px]){
            parent[py] = px;
        }
        else{
            parent[px] = py;
            rank[py]++;
        }
    }


    public boolean containsCycle(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        parent = new int[n * m];
        rank = new int[n * m];

        for(int i=0; i<n*m; i++){
            parent[i] = i;
            rank[i] = 0;
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){

                int curr = i * m + j;

                // right
                if(j + 1 < m && grid[i][j] == grid[i][j + 1]){
                    int next = i * m + (j + 1);

                    if(find(curr) == find(next)){
                        return true;
                    }

                    union(curr, next);


                }
                
                if(i + 1 < n && grid[i][j] == grid[i + 1][j]){
                    int next = (i + 1) * m + j;

                    if(find(curr) == find(next)){
                        return true;
                    }

                    union(curr, next);


                }

            }
        }

        return false;


        
    }
}