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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();

        if(root == null){
            return new ArrayList<>();
        }

        q.add(root);

        ArrayList<Integer> list = new ArrayList<>();

        while(!q.isEmpty()){
            int count = q.size();

            for(int i=0; i<count; i++){
                TreeNode currNode = q.poll();
                if(i + 1 == count){
                    list.add(currNode.val);
                }

                if(currNode.left != null){
                    q.add(currNode.left);
                }

                if(currNode.right != null){
                    q.add(currNode.right);
                }
            }
        }

        return list;
        
    }
}