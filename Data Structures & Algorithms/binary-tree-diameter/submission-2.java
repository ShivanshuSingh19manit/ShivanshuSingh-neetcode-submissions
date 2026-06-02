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

    public int dfs(TreeNode root){
        if(root == null){
          return 0;
        }
        int lefth = dfs(root.left);
        int righth = dfs(root.right);

        ans = Math.max(ans,(lefth+righth));
        return 1 + Math.max(lefth,righth);
    }

    public int diameterOfBinaryTree(TreeNode root) {
       int k = dfs(root);
       return ans;
    }
}
