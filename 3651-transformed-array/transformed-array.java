class Solution {
    public int[] constructTransformedArray(int[] arr) {
        int[] nums = new int[arr.length];

        for(int i=0; i<arr.length; i++){
            if(arr[i] == 0){
                nums[i] = 0;
            }
            
            int x = ((i  + arr[i]) % arr.length + arr.length) % arr.length;
            nums[i] = arr[x];
            
        }

        return nums;
        
    }
}

// 3, -2, 2, 1, 1