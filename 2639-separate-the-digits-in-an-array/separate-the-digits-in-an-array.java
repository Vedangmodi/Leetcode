class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for (int num : nums) {
            String s = String.valueOf(num);  // convert number to string
            
            for (char c : s.toCharArray()) {
                result.add(c - '0');  // convert char to digit
            }
        }

        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }
}