class Solution {
    public int minimumCost(int[] arr) {
        Arrays.sort(arr);
        int count = 1;
        int sum = 0;

        for(int i = arr.length - 1; i>=0; i--){
            if(count % 3 == 0){
                count++;
                continue;

            }
            else{
                sum = sum + arr[i];
                count++;
            }
            

        }

        return sum;
        
    }
}
// [6,5,7,9,2,2]
// 2 2 5 6 7 9