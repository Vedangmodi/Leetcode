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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        boolean flag = true;

        if(root == null){
            return new ArrayList<>();
        }

        q.add(root);

        List<List<Integer>> ans = new ArrayList<>();

        while(!q.isEmpty()){
            int count = q.size();

            ArrayList<Integer> list = new ArrayList<>();

            for(int i=0; i<count; i++){
                TreeNode currNode = q.poll();

                list.add(currNode.val);

                if(currNode.left != null){
                    q.add(currNode.left);
                }

                if(currNode.right != null){
                    q.add(currNode.right);
                }
            }

            if(!flag){
                Collections.reverse(list);
                flag = true;
            }
            else{
                flag = false;
            }
 
            ans.add(list);
            
        }

        return ans;
        
    }
}