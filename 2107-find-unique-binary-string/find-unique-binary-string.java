class Solution {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i<nums.length; i++){
            char ch = nums[i].charAt(i);
            if(ch == '1'){
                ch = '0';
            }
            else if(ch == '0'){
                ch = '1';
            }
            sb.append(ch);
        }

        return sb.toString();
        
    }

}