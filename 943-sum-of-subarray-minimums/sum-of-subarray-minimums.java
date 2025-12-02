class Solution {
    public int sumSubarrayMins(int[] arr) {
        int[] arr1 = prevSmall(arr);
        int[] arr2 = nextSmall(arr);

        // int[] nums = new int[arr.length];

        long count = 0;

        for(int i=0; i<arr.length; i++){
            long x = i - arr1[i];
            long y = arr2[i] - i;

            long z = x * y;

            count = (count + (z * arr[i])) % 1000_000_007;
            // count = count + (z * arr[i]);

        }

        return (int)count;
        
    }

    public int[] prevSmall(int[] arr){
        Stack<Integer> stack = new Stack<>();

        int[] nums = new int[arr.length];

        for(int i=0; i<arr.length; i++){

            // while(!stack.isEmpty() && arr[stack.peek()]  >= arr[i]){
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]){
                stack.pop();
            }

            if(stack.isEmpty()){
                nums[i] = -1;
            }
            // else if(arr[stack.peek()]  < arr[i]){
            else{
                nums[i] = stack.peek();
            }

            stack.push(i);
        }

        return nums;
    }

    public int[] nextSmall(int[] arr){
        Stack<Integer> stack = new Stack<>();
        int[] nums = new int[arr.length];

        for(int i = arr.length - 1; i>=0; i--){
            while(!stack.isEmpty() && arr[stack.peek()]  >= arr[i]){
                stack.pop();
            }

            if(stack.isEmpty() ){
                nums[i] = arr.length;
            }
            // else if(arr[stack.peek()]  < arr[i]){
            else{
                nums[i] = stack.peek();
            }

            stack.push(i);
        }

        return nums;
    }
}