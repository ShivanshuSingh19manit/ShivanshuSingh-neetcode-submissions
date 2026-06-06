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

   public boolean isSameTree(TreeNode p, TreeNode q){
        if(p == null && q == null){
            return true;
        }else if(p == null || q == null){
            return false;
        }
        if(p.val != q.val){
            return false;
        }else if(p.val == q.val){
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }
        return true;
   }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
          if(subRoot == null){
            return true;
          }
          if(root == null){
            return false;
          }
          boolean res = isSameTree(root,subRoot);
          if(res == true){
            return true;
          }
          return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }
}
