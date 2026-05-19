class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int i= 0 ;
        int j = 0;

        while(i < nums1.length && j < nums2.length){
            if(nums1[i] == nums2[j]){
                return nums1[i];
            }
            else if(nums1[i] > nums2[j]){
                j++;
            }
            else if(nums1[i] < nums2[j]){
                i++;
            }
        }

        if(i == nums1.length){
            while(j < nums2.length){
                if(nums1[i - 1] == nums2[j]){
                    return nums2[j];
                }
                j++;
            }
        }

        if(j == nums1.length){
            while(i < nums2.length){
                if(nums1[j - 1] == nums2[i]){
                    return nums1[i];
                }
                i++;
            }
        }

        return -1;




        
    }
}