/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */

class Solution {
public:
    
    string seraliseTree(TreeNode* root){
        if(root == NULL){
            return "#$";
        }
       return "$" + to_string(root->val) + seraliseTree(root->left) + seraliseTree(root->right);

    }

  vector<int> z_function(string s){
   int n = s.size();
   int l = 0;
   int r = 0;
   vector<int>z(n,0);

   for(int i=1;i<n;i++){
    // Inside window
    if(i<=r){
        z[i] = min(r-i+1 , z[i-l]);
    }

    while(i+ z[i]<n && s[z[i]]==s[i + z[i]]){
        z[i]++;
    }

    if(i+z[i]-1>r){
        l = i;
        r = i + z[i] -1;
    }
   }
    return z;

  }


    bool isSubtree(TreeNode* root, TreeNode* subRoot) {
        string rootser = seraliseTree(root);
        string subrootser = seraliseTree(subRoot);

        string combstr = subrootser + "|" + rootser;
        vector<int> z = z_function(combstr);
        for(int i = subrootser.size()+1;i<combstr.size();i++){
            if(z[i]==subrootser.size()){
                return true;
            }
        }
        return false;
    }
};
