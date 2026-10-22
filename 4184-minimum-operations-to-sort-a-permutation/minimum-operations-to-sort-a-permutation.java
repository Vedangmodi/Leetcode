// class Solution {
//     public int minOperations(int[] arr) {

//         int n = arr.length

//         int[] nums = arr.clone();
//         Arrays.sort(nums);

//         if(Arrays.equals(nums, arr)){
//             return 0;
//         }

//         int idx = 0;
//         boolean flag = false;

//         for(int i=1; i<n-1; i++){
//             if(arr[i] < arr[i + 1] && arr[i] < arr[i - 1]){
//                 idx = i;
//                 break;
//             }

//             if(i == n - 1 && arr[i] > arr[i + 1]){
//                 idx = i + 1;
//             }

//         }
  
//     }
// }

class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }

        // Locate the position of 0
        int zeroIndex = 0;
        while (nums[zeroIndex] != 0) {
            zeroIndex++;
        }

        boolean isIncreasing = true;
        boolean isDecreasing = true;

        // Read circularly starting from 0 and validate both patterns
        for (int step = 1; step < n; step++) {
            int value = nums[(zeroIndex + step) % n];
            if (value != step) {
                isIncreasing = false;
            }
            if (value != n - step) {
                isDecreasing = false;
            }
            if (!isIncreasing && !isDecreasing) {
                return -1;
            }
        }

        if (isIncreasing) {
            return Math.min(zeroIndex, n - zeroIndex + 2);
        }
        return Math.min(n - zeroIndex, zeroIndex + 2);
    }
}