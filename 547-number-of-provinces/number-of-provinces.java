class Solution {
    int[] parent;
    int[] rank;

    public int find(int i){
        if(parent[i] != i){
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }

    public void union(int x, int y){
        int px = find(x);
        int py = find(y);

        if(px == py){
            return;
        }


        if(rank[px] > rank[py]){
            parent[py] = px;
        }
        else if(rank[px] < rank[py]){
            parent[px] = py;
        }
        else{
            parent[py] = px;
            rank[px]++;
        }
    }

    public int findCircleNum(int[][] mat) {
        int n = mat.length;

        parent = new int[n];
        rank = new int[n];

        for(int i=0 ;i<n; i++){
            parent[i] = i;
        }

        //union step
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] == 1){
                    union(i, j);

                }
            }
        }

        int count = 0;

        for(int i=0; i<n; i++){
            if(parent[i] == i){
                count++;
            }

        }

        return count;
        
    }
}










