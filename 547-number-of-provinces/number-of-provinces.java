class Solution {
    public int findCircleNum(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for(int i=0; i<n; i++){
            map.put(i, new ArrayList<Integer>()) ;
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(mat[i][j] == 1){
                    map.get(i).add(j);
                    map.get(j).add(i);

                }
                
            }
        }

        boolean[] visited = new boolean[n];
        int count = 0;

        for(int i=0; i<n; i++){
            if(!visited[i]){
                count++;
                dfs(map, visited, i);
                
            }
        }

        return count;
         
    }

    public void dfs(HashMap<Integer, ArrayList<Integer>> map, boolean[] visited, int x){
        visited[x] = true;

        for(int i : map.get(x)){
            if(!visited[i]){
                dfs(map, visited, i);
            }

        }


    }
}

// [1,1,0],
// [1,1,0],
// [0,0,1]