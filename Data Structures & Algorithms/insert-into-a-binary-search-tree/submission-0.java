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

    ArrayList<Integer> inorderVal = new ArrayList<Integer>();
   public void inorder(TreeNode root){
        if(root == null){
            return;
        }
        inorder(root.left);
        inorderVal.add(root.val);
        inorder(root.right);
   }
   TreeNode buildTree(ArrayList<Integer> nums, int left, int right){
       if(left>right){
        return null;
       }
       int mid = left+(right-left)/2;
       TreeNode root = new TreeNode(nums.get(mid));
       root.left = buildTree(nums,left,mid-1);
       root.right = buildTree(nums,mid+1,right);

       return root;
   } 

    public TreeNode insertIntoBST(TreeNode root, int val) {
        inorder(root);
        inorderVal.add(val);
        Collections.sort(inorderVal);
        return buildTree(inorderVal,0,inorderVal.size()-1);


    }
}