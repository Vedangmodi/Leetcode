/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        findMaxSumUtil(root);
        return ans;
        
    }

    int findMaxSumUtil(TreeNode root){

        if(root == null){
            return 0;
        }
        // int lstSum = findMaxSumUtil(root.left);
        // int rstSum = findMaxSumUtil(root.right);

        int lstSum = Math.max(0, findMaxSumUtil(root.left));   
        int rstSum = Math.max(0, findMaxSumUtil(root.right)); 


        int maxSideSum = root.val + Math.max(lstSum, rstSum);
        int maxNodeSum = Math.max(maxSideSum, root.val);

        int allSum = root.val + lstSum + rstSum;

        ans = Math.max(ans, Math.max(allSum, maxNodeSum));

        return maxSideSum;
    }   
}




       
