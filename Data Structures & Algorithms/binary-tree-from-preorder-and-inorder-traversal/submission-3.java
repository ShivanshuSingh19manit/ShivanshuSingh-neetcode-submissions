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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length  == 0 || inorder.length == 0){
            return null;
        }
        TreeNode  root = new TreeNode(preorder[0]);
        int idx = 0;
        while(inorder[idx] != preorder[0]){
            idx++;
        }
        int[] leftInorder = Arrays.copyOfRange(inorder,0,idx);
        int[] rightInorder = Arrays.copyOfRange(inorder,idx+1,inorder.length);

        int[] leftPreorder = Arrays.copyOfRange(preorder,1,idx+1);
        int[] rightPreorder = Arrays.copyOfRange(preorder,idx+1,preorder.length);

        root.left = buildTree(leftPreorder,leftInorder);
        root.right = buildTree(rightPreorder,rightInorder);

        return root;
    }
}
