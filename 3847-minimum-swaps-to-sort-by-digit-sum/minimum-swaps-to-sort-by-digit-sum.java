class Solution {

    record Pair(int first, int second){}

    public void swap(Pair[] p, int i, int j){
        Pair temp = p[i];
        p[i] = p[j];
        p[j] = temp;

    }

    public int minSwaps(int[] nums) {
        int n = nums.length;

        Pair[] arr = new Pair[n];

        for(int i=0; i<n; i++){
            arr[i] = new Pair(nums[i], i);
        }

        Arrays.sort(arr, (a,b) -> {
            int sum1 = fun(a.first);
            int sum2 = fun(b.first);

            if(sum1 == sum2){
                return Integer.compare(a.first, b.first);
            }

            return Integer.compare(sum1, sum2);
        });

        int count = 0;

        int i = 0;

        while(i < n){
            if(arr[i].second != i){
                swap(arr, arr[i].second, i);
                count++;
            }
            else{
                i++;
            }
        }

        return count;
        
    }

    

    public int fun(int num){
        int sum = 0;

        while(num > 0){
            sum += num % 10;
            num /= 10;
        }

        return sum;
    }
}