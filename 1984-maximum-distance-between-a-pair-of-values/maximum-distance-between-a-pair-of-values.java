class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int i = 0;
        int j = 0;

        int max = 0;

        while(i < m && j < n){
            while(j < n && i <= j &&  nums1[i] <= nums2[j]){
                max = Math.max(max , j - i);
                j++;
            }

            if(i > j ){
                i++;
            }
            else if(i < m && j < n && nums1[i] > nums2[j]){
                i++;
                j++;
            }
        }

        return max;



        
    }
}

