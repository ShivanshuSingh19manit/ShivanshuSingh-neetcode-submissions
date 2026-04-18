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

    public  String serlazieTree(TreeNode root){
        if(root == null){
            return "$#";
        }
        return "$" + root.val + serlazieTree(root.left) + serlazieTree(root.right);
    }

    public int[] z_function(String s){
        int l = 0;
        int r = 0;
        int n = s.length();
        int[] z = new int[n];

        for(int i=1;i<n;i++){
            // inside window case 
            if(i<=r){
                z[i] = Math.min(r-i+1, z[i-l]);
            }
            while(i+z[i]<n && s.charAt(z[i]) == s.charAt(i+ z[i])){
                z[i]++;
            }
            // update Window 
            if(i+z[i]-1>r){
                l = i;
                r = i+z[i]-1;
            }
        }
             return z;
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
          String rootser = serlazieTree(root);
          String subrootser = serlazieTree(subRoot);

          String newComb = subrootser + "|" + rootser;
          int[] z_valuse = z_function(newComb);

          for(int i =subrootser.length()+1;i<newComb.length();i++){
            if(z_valuse[i] == subrootser.length()){
                return true;
            }
          }
          
          return false;
    }
}
