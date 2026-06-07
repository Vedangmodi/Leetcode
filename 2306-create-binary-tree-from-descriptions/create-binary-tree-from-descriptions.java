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
    public TreeNode createBinaryTree(int[][] des) {
        Set<Integer> set = new HashSet<>();

        for(int i=0; i<des.length; i++){
            set.add(des[i][1]);
        }

        int rootvalue = 0;

        for(int i=0; i<des.length; i++){
            int a = des[i][0];

            if(!set.contains(a)){
                rootvalue = a;
                break;
            }

        }

        HashMap<Integer, TreeNode > map = new HashMap<>();

        for(int i=0; i<des.length; i++){
            int a = des[i][0];
            int b = des[i][1];
            int c = des[i][2];

            TreeNode node1 = new TreeNode(a);
            TreeNode node2 = new TreeNode(b);

            if(!map.containsKey(a)) map.put(a, node1);

            if(!map.containsKey(b)) map.put(b, node2);

            TreeNode parent = map.get(a);
            TreeNode child = map.get(b);

            if(c == 1){
                parent.left = child;
            }
            else{
                parent.right = child;
            }

        }

        TreeNode ans = map.get(rootvalue);

        return ans;


     
    }

}



// c = 1   -   left
// c = 0  -   right