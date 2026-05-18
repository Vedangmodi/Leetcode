class Solution {
    public int minJumps(int[] arr) {
        if(arr.length == 1){
            return 0;
        }

        int n = arr.length;

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for(int i=0; i<n; i++){
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);

        }

        boolean[] visited = new boolean[n];

        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        int count = 0;

        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0; i<size; i++){
                int idx = q.poll();
                int num = arr[idx];

                if(idx == n - 1){
                    return count;
                }

                if(idx - 1 >= 0 && visited[idx - 1] == false){
                    q.add(idx - 1);
                    visited[idx - 1] = true;
                }

                if(idx + 1 <= n - 1 && visited[idx + 1] == false){
                    q.add(idx + 1);
                    visited[idx + 1] = true;
                }

                if(map.containsKey(num)){
                    ArrayList<Integer> list = map.get(num);

                    for(int x : list){
                        // if(visited[i] == false){
                            q.add(x);
                        //     visited[x] = true;
                        // }
                    }

                    map.remove(num);
                }

                

            }

            count++;


        }

        return count;

        
    }
}