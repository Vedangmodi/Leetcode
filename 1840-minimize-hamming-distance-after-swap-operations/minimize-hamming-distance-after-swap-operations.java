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
        else if(rank[py] > rank[px]){
            parent[px] = py;
        }
        else{
            parent[py] = px;
            rank[px]++;

        }
    }
    public int minimumHammingDistance(int[] source, int[] target, int[][] mat) {
        int n = mat.length;

        int p = target.length;

        parent = new int[p];
        rank = new int[p];

        for(int i=0 ;i<p; i++){
            parent[i] = i;
        }

        for(int i=0; i<n; i++){
            int x = mat[i][0];
            int y = mat[i][1];

            union(x, y);
        }

        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();

        for(int i=0; i<p; i++){
            int root = find(i);

            map.putIfAbsent(root, new HashMap<>());

            HashMap<Integer, Integer> freq = map.get(root);
            freq.put(source[i], freq.getOrDefault(source[i], 0) + 1);
        }

        int count = 0;

        for(int i=0; i<p; i++){
            int root = find(i);

            HashMap<Integer, Integer> freq = map.get(root);

            if(freq.getOrDefault(target[i], 0) > 0){
                freq.put(target[i], freq.get(target[i]) - 1);
            }
            else{
                count++;
            }
        }

        return count;


        
    }
}