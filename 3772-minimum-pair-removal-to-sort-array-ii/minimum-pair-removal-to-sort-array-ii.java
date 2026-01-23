class Solution {
    public int minimumPairRemoval(int[] nums) {

        int[] pre = new int[nums.length];
        int[] nex = new int[nums.length];

        for(int i = 0; i<nums.length; i++){
            pre[i] = i - 1;
            nex[i] = i + 1;
        }

        int badPairs = 0;

        long[] arr = new long[nums.length];
        for(int i=0; i<arr.length; i++){
            arr[i] = nums[i];
        }

        for(int i=1; i<arr.length; i++){
            if(arr[i - 1] > arr[i]){
                badPairs++;
            }
        }

        TreeSet<Pair> set = new TreeSet<>(
            (a,b) -> {
            if(a.sum != b.sum){
                return Long.compare(a.sum, b.sum);
            }
            return Integer.compare(a.idx, b.idx);
        }
        );

        for(int i=1; i<arr.length; i++){
            long sumPair = arr[i] + arr[i-1];
            
            set.add(new Pair(sumPair, i - 1));

        }

        

        int count = 0;

        while(badPairs > 0 &&  !set.isEmpty()){

            Pair smallest = set.first(); // (4, 2)
            set.remove(smallest);
            int first = smallest.idx;  // 2

            // Pair leftPair = set.floor(new Pair( Long.MAX_VALUE, index - 1));
            // int leftIndex = leftPair.idx;

            // Pair rightPair = set.ceiling(new Pair(Long.MIN_VALUE, index + 1));
            // int rightIndex = rightPair.idx;

            int second = nex[first]; // 3
            if(second >= arr.length){
                continue;
            }

            int leftFirst = pre[first];  // 1
            int rightSecond = nex[second];  // 4

            if(arr[first] > arr[second]) {
                badPairs--;
            }

            // (a, b) c

            if(leftFirst >= 0){
                if(arr[leftFirst] > arr[first] &&  arr[leftFirst] <= arr[first] + arr[second]){
                    badPairs--;

                } 
                else if(arr[leftFirst] <= arr[first] && arr[leftFirst] > arr[first] +  arr[second]){
                    badPairs++;
                }
            }

            // a (b, c)
            if(rightSecond < arr.length){
                if (arr[rightSecond] >= arr[second] && arr[rightSecond] < arr[first] + arr[second]) {
                    badPairs++;
                }
                else if (arr[rightSecond] < arr[second] && arr[rightSecond] >= arr[first] + arr[second]) {
                    badPairs--;
                }
            }
            
            if(leftFirst >= 0){
                set.remove(new Pair(arr[leftFirst] + arr[first], leftFirst));
                set.add(new Pair(arr[leftFirst] + arr[first] + arr[second], leftFirst));
            }

            if(rightSecond < arr.length){
                set.remove(new Pair(arr[second] + arr[rightSecond] , second));

                set.add(new Pair(arr[first] + arr[second] + arr[rightSecond] , first));

                pre[rightSecond] = first;

            }

            nex[first] = rightSecond;

            arr[first] = arr[first] + arr[second];
            count++;



        }

        return count;





    }

    
}

public class Pair{
    long sum;
    int idx;

    Pair(long sum, int idx){
        this.sum = sum;
        this.idx = idx;
    }

    @Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Pair)) return false;
    Pair p = (Pair) o;
    return sum == p.sum && idx == p.idx;
}

@Override
public int hashCode() {
    return Objects.hash(sum, idx);
}

}



