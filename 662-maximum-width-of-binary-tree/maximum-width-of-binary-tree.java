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
    public int widthOfBinaryTree(TreeNode root) {

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(root, 0));

        int max = 0;

        while(!q.isEmpty()){
            int count = q.size();

            int minIdx = q.peek().index;
            int maxIdx = 0;

            for(int i=0; i<count; i++){
                Pair currpair = q.poll();

                TreeNode currNode = currpair.node;
                int currIdx = currpair.index;

                if(i + 1 == count){
                    maxIdx = currIdx;
                }

                if(currNode.left != null){
                    q.add(new Pair(currNode.left, 2 * currIdx + 1 ));
                }

                if(currNode.right != null){
                    q.add(new Pair(currNode.right, 2 * currIdx + 2 ));
                }

            }

            max = Math.max(max,maxIdx - minIdx + 1 );
        }

        return max;
        
    }
}

class Pair{
    TreeNode node;
    int index;

    public Pair(TreeNode node, int index){
        this.node = node;
        this.index = index;
    }


}