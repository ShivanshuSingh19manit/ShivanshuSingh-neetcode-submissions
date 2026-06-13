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

     HashMap<Integer, Integer> map = new HashMap<>();

   public TreeNode build(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd){
       
       if(preStart > preEnd || inStart > inEnd){
        return null;
       }

       int value = preorder[preStart];
       TreeNode root = new TreeNode(value);
       
       int idx = map.get(value);
       int leftsize = idx - inStart;

       root.left = build(preorder,inorder, preStart + 1, preStart + leftsize, inStart, idx - 1);

       root.right = build(preorder,inorder, preStart + leftsize + 1, preEnd, idx + 1, inEnd );
       return root;



   }


    public TreeNode buildTree(int[] preorder, int[] inorder) {

        for(int i = 0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }

        return build(preorder,inorder,0, preorder.length - 1, 0, inorder.length - 1 );
    }
}
