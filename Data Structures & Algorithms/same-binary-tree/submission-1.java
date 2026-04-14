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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode>q1 = new LinkedList<>();
        Queue<TreeNode>q2 = new LinkedList<>();

        q1.add(p);
        q2.add(q);

        while(!q1.isEmpty() && !q2.isEmpty()){
           int size = q1.size();
           for(int i=0;i<size;i++){
            TreeNode p1 = q1.poll();
            TreeNode p2 = q2.poll();
            
            if(p1 == null && p2 == null) continue;
            if(p1 == null || p2 == null || p1.val != p2.val) return false;
             q1.add(p1.left);
             q1.add(p1.right);
             q2.add(p2.left);
             q2.add(p2.right);
           }

        }
   return true;
    }
}
