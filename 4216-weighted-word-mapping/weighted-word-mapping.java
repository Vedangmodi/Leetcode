class Solution {
    public String mapWordWeights(String[] nums, int[] arr) {

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<nums.length; i++){
            String str = nums[i];
            int count = 0;

            for(int j=0; j<str.length(); j++){
                int idx = str.charAt(j) - 'a';

                count = count + arr[idx];
                
            }

            int ans = count % 26;
            sb.append((char)('a' + 25 - ans));
        }

        return sb.toString();
        
    }
}