class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {

        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        int[] inDegree = new int[n];
        boolean[] sus = new boolean[n];

        for(int[] edg : invocations){
            int u = edg[0];
            int v = edg[1];

            adj.get(u).add(v);
            inDegree[v]++;
        }


        // now apply BFS

        Queue<Integer> q = new LinkedList<>();
        q.offer(k);
        sus[k] = true;

        while(!q.isEmpty()){
            int curr = q.poll();

            for(int num : adj.get(curr)){
                inDegree[num]--;
                if(!sus[num]){
                    sus[num] = true;
                    q.offer(num);
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        boolean cannotremove = false;

        for(int i=0; i<n; i++){
            if(sus[i] && inDegree[i] > 0){
                cannotremove = true;
                break;
            }
            
            if(!sus[i]){
                res.add(i);
            }
        }

        if(cannotremove){
            List<Integer> list = new ArrayList<>();

            for(int i=0; i<n; i++){
                list.add(i);
            }

            return list;
        }

        return res;



        
    }
}
