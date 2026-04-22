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

    public boolean dfs(TreeNode root, long minVal, long maxVal){
        if(root == null){
            return true;
        }
        if(!(minVal < root.val && root.val < maxVal)){
            return false;
        }
        return dfs(root.left,minVal,root.val) && dfs(root.right,root.val,maxVal);
    }

    public boolean isValidBST(TreeNode root) {
        return dfs(root,Long.MIN_VALUE, Long.MAX_VALUE);
    }
}
