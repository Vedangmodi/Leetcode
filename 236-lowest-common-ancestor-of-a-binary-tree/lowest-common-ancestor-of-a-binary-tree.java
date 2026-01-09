/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode n1, TreeNode n2) {
        if(root == null){
        return null;
       }

       if(root.val == n1.val || root.val == n2.val){
        return root;
       }

       TreeNode lcaleft = lowestCommonAncestor(root.left, n1, n2);
       TreeNode lcaright = lowestCommonAncestor(root.right, n1, n2);

       if(lcaleft != null && lcaright != null){
        return root;
       }

       if(lcaleft != null){
        return lcaleft;
       }

       if(lcaright != null){
        return lcaright;
       }

       return null;
        
    }
}