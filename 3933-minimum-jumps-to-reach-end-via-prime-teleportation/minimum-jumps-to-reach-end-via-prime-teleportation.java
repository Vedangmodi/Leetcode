class Solution {
    public int minJumps(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int i=0; i<nums.length; i++){
            if(isPrime(nums[i])){
                set.add(nums[i]);
            }
        }

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        // for(int i=0; i<nums.length; i++){
        //     map.computeIfAbsent(nums[i],k -> new ArrayList<>()).add(i);
        // }

        for(int prime : set){
            map.put(prime, new ArrayList<>());

        }

        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            for (int f = 2; f * f <= val; f++) {
                if (val % f == 0 && set.contains(f)) {
                    map.get(f).add(i);
                }
                while (val % f == 0) val /= f; // remove factor
            }
            // check remaining prime factor
            if (val > 1 && set.contains(val)) {
                map.get(val).add(i);
            }
        }

        boolean[] visited = new boolean[nums.length];

        Queue<Pair> q = new LinkedList<>();

        int count = 0;

        Pair x = new Pair(nums[0], 0);
        visited[0] = true;

        q.offer(x);

        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0; i<size; i++){
                Pair curr = q.poll();

                int currIdx = curr.idx;

                if(currIdx == nums.length - 1){
                    return count;
                }

                // move +1
                if(currIdx + 1 < nums.length && !visited[currIdx + 1]){
                    q.offer(new Pair(nums[currIdx + 1], currIdx + 1));
                    visited[currIdx + 1] = true;

                }

                // move -1
                if(currIdx - 1 >= 0 && !visited[currIdx - 1]){
                    q.offer(new Pair(nums[currIdx - 1], currIdx - 1));
                    visited[currIdx - 1] = true;

                }

                if(set.contains(nums[currIdx])){
                    int p = nums[currIdx]; 

                    for(int w : map.getOrDefault(p, new ArrayList<>())){
                        if(!visited[w]){
                            q.offer(new Pair(nums[w], w));
                            visited[w] = true; 
                        }
                    }

                    map.put(p, new ArrayList<>());


                }



                
            }
            count++;
        }

        return count;
    }

    public boolean isPrime(int x){
        if(x <= 1){
            return false;
        }

        for(int i = 2; i * i <= x; i++){
            if(x % i == 0){
                return false;
            }
        }

        return true;
    }
}

class Pair{
    int num;
    int idx;

    public Pair(int num, int idx){
        this.num = num;
        this.idx = idx;
    }
}