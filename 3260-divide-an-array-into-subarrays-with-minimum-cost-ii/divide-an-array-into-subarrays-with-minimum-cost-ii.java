class Solution {
    public long minimumCost(int[] arr, int k, int dist) {

        TreeSet<Pair> set = new TreeSet<>(
            (a, b) -> {
                if(a.num != b.num){
                    return a.num - b.num;
                }
                return a.idx - b.idx;
            }
        );

        TreeSet<Pair> tree = new TreeSet<>(
            (a, b) -> {
                if(a.num != b.num){
                    return a.num - b.num;
                }
                return a.idx - b.idx;
            }
        );

        long sum = 0;

        int i = 1;

        // while(i < arr.length && i - dist < 1){
            while(i < arr.length && i - dist < 1){
            set.add(new Pair(arr[i], i));
            sum += arr[i];

            if(set.size() > k - 1){
                Pair curr = set.pollLast();
                sum -= curr.num;
                tree.add(curr);
            }

            i++;

        }
        // int j = 1;

        long res = Long.MAX_VALUE;

        while(i < arr.length){
            set.add(new Pair(arr[i], i));
            sum = sum + arr[i];

            if(set.size() > k -1){
                Pair curr = set.pollLast();
                tree.add(curr);
                sum = sum - curr.num;
            }

            res = Math.min(res, sum);

            int removeIdx = i - dist;
            Pair removePair = new Pair(arr[removeIdx], removeIdx);

            if(set.contains(removePair)){
                set.remove(removePair);
                sum = sum - removePair.num;

                if(!tree.isEmpty()){
                    Pair curr = tree.pollFirst();
                    set.add(curr);
                    sum = sum + curr.num;
                }
            }
            else{
                tree.remove(removePair);
            }

            i++;

        }

        return res + arr[0];

        
    }
}

class Pair{
    int num;
    int idx;

    Pair(int num, int idx){
        this.num = num;
        this.idx = idx;
    }
}


// 1,3,2,6,4,2

// 0 1 2 3 4 5