class Solution {
    public int[] nextGreaterElements(int[] arr) {
        Stack<Integer> stack = new Stack<>();

        int[] nums = new int[arr.length];

        for(int i=arr.length - 1; i>=0; i--){
            while(!stack.isEmpty() && stack.peek() <= arr[i]){
                stack.pop();
            }

            
                stack.push(arr[i]);              
            // }
        }

        for(int i=arr.length - 1; i>=0; i--){
            while(!stack.isEmpty() && stack.peek() <= arr[i]){
                stack.pop();
            }

            if(stack.isEmpty()){
                nums[i] = -1;
            }
            else{
                nums[i] = stack.peek();
            }
            stack.push(arr[i]);

        }
        return nums;


        
    }
}