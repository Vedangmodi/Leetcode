class Solution {
    public boolean canReach(int[] arr, int start) {
        if(arr[start] == 0){
            return true;
        }

        Queue<Integer> q = new LinkedList<>();

        q.add(start);

        boolean[] visited = new boolean[arr.length];
        visited[start] = true;

        while(!q.isEmpty()){
            int n = q.size();

            for(int i=0; i<n; i++){
                int num = q.poll();

                if(arr[num] == 0){
                    return true;
                }

                int a = num + arr[num];
                int b = num - arr[num];

                if(a < arr.length && visited[a] == false){
                    q.add(a);
                    visited[a] = true;
                }

                if(b >= 0 && visited[b] == false){
                    q.add(b);
                    visited[b] = true;
                }
            } 
        }

        return false;
        
    }
}

//  0 1 2 3 4
// [3,0,2,1,2]

// q - 1 4
// q - 3 2
// q - 2 4 0 2


// if(q.size() == n - 1 ){
//                 return 0;
//             }