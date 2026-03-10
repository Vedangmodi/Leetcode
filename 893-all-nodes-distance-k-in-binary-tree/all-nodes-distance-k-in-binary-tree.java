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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        ArrayList<Integer> list = new ArrayList<>();

        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        // map.put(root);

        fun(root, map);

        HashSet<TreeNode> set = new HashSet<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);

        set.add(target);

        int dist = 0;

        while(!q.isEmpty()){
            int count = q.size();

            if(dist == k){
                break;
            }

            for(int i=0; i<count; i++){
                TreeNode curr = q.poll();
                TreeNode parent = map.get(curr);

                if(parent != null && !set.contains(parent)){
                    q.add(parent);
                    set.add(parent);
                }

                if(curr.left != null && !set.contains(curr.left)){
                    q.add(curr.left);
                    set.add(curr.left);
                }

                if(curr.right != null && !set.contains(curr.right)){
                    q.add(curr.right);
                    set.add(curr.right);
                }

            }

            dist++;
            
        }

        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            list.add(curr.val);
            
        }

        return list;




        
    }

    public void fun(TreeNode root, HashMap<TreeNode, TreeNode> map){

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int count = q.size();

            for(int i=0; i<count; i++){
            
                TreeNode curr = q.poll();

                if(curr.left != null){
                    q.add(curr.left);
                    map.put(curr.left, curr);

                }

                if(curr.right != null){
                    q.add(curr.right);
                    map.put(curr.right, curr);

                }

            }

        }

    }
}