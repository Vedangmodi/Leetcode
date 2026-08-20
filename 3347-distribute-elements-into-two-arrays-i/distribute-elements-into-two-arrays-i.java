class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        
        ArrayList<Integer> ls1 = new ArrayList<>();
        ArrayList<Integer> ls2 = new ArrayList<>();

        ls1.add(nums[0]);
        ls2.add(nums[1]);

        for(int i=2; i<n; i++){
            if(ls1.get(ls1.size() - 1) > ls2.get(ls2.size() - 1)){
                ls1.add(nums[i]);
            }
            else{
                ls2.add(nums[i]);
            }
        }

        int[] arr = new int[n];

        for(int i=0; i<ls1.size(); i++){
            arr[i] = ls1.get(i);
        }

        int z = 0;

        for(int i=ls1.size(); i<n; i++){
            arr[i] = ls2.get(z);
            z++;
        }

        return arr;



        
    }
}

