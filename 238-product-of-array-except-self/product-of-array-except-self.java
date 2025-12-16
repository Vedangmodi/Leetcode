class Solution {
    public int[] productExceptSelf(int[] nums){
        int n = nums.length;
        int[] arr = new int[n];

        arr[0] = 1; 

        for(int i = 1; i<nums.length; i++){
            arr[i] = arr[i - 1] * nums[i - 1];
        }

        int right = 1;

        for(int i = n - 1; i>=0; i--){
            arr[i] = arr[i] * right;
            right *= nums[i];
        }

        return arr;
       
    }
}


    // public int[] productExceptSelf(int[] nums) {
    //     int[] arr = new int[nums.length];
        
    //     for(int i=0; i<nums.length; i++){
    //         int a = left(i,nums);
    //         int b = right(i,nums);

    //         int n = a * b;
    //         arr[i] = n;
    //     }
    //     return arr;

        
    // }
    // public int left(int x, int[] arr){
    //     int product = 1;
    //     if(x == 0) return 1;
    //     for(int i=x -1; i>=0; i--){
    //         product = product * arr[i];
    //     }
    //     return product;
    // }

    // public int right(int x, int[] arr){
    //     int product = 1;
    //     if(x == arr.length - 1) return 1;

    //     for(int i= x + 1; i<arr.length; i++){
    //         product = product * arr[i];
    //     }
    //     return product;
    // }
