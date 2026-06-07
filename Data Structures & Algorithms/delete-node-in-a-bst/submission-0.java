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
   
    ArrayList<Integer>inorder = new ArrayList<Integer>();
    public void inorder(TreeNode root){
        if(root == null){
              return;
        }
        inorder(root.left);
        inorder.add(root.val);
        inorder(root.right);
    }
    
    public TreeNode BuildTree(ArrayList<Integer>inorder, int left , int right){
          if(left > right){
            return null;
          }
          int mid = left + (right-left)/2;

          TreeNode root = new TreeNode(inorder.get(mid));
          root.left = BuildTree(inorder, left, mid-1);
          root.right = BuildTree(inorder, mid+1, right);

          return root;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        inorder(root);
        int size = inorder.size();
        for(int i=0;i<size;i++){
            if(inorder.get(i) == key){
                inorder.remove(i);
                break;
            }
        }
       return BuildTree(inorder,0, inorder.size()-1);

    }
}