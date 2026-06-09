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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
       
        if(root == null){
          return res;
        }
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);
        while(!q.isEmpty()){
          int size = q.size();
          List<Integer> temp = new ArrayList<>();

          for(int i = 0;i<size;i++){
            TreeNode tempN = q.poll();
            temp.add(tempN.val);
            if(tempN.left != null){
              q.add(tempN.left);
            }
            if(tempN.right != null){
              q.add(tempN.right);
            }
          }
          res.add(temp);
        }
        return res;
    }
}
