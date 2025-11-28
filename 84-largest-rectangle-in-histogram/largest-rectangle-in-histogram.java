class Solution {
    public int largestRectangleArea(int[] arr) {
        int[] arr1 = nextSmall(arr);
        int[] arr2 = prevSmall(arr);

        int[] nums = new int[arr.length];

        for(int i=0; i<arr.length; i++){
            nums[i] = arr1[i] - arr2[i] - 1;
        }

        int max = Integer.MIN_VALUE;

        for(int i=0; i<arr.length; i++){
            max = Math.max(max, arr[i] * nums[i]);
        }

        return max;
        
    }


    public int[] nextSmall(int[] arr){
        Stack<Integer> stack = new Stack<>();

        int[] nums = new int[arr.length];

        for(int i = arr.length - 1; i>=0; i--){

            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }

            if(stack.isEmpty()){
                nums[i] = arr.length;
            }
            else if(arr[stack.peek()] < arr[i]){
                nums[i] = stack.peek();
            }

            stack.push(i);
        }

        return nums;
    }

    public int[] prevSmall(int[] arr){
        Stack<Integer> stack = new Stack<>();
        int[] nums = new int[arr.length];

        for(int i=0; i<arr.length; i++){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }

            if(stack.isEmpty()){
                nums[i] = -1;
            }
            else if(arr[stack.peek()] < arr[i]){
                nums[i] = stack.peek();
            }

            stack.push(i);
        }

        return nums;
    }
}