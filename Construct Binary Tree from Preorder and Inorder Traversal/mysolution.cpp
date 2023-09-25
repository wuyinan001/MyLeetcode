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
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        if(preorder.empty())
            return NULL;
        
        int val=preorder[0];
        
        TreeNode* ans=new TreeNode(val);
        
        int index=distance(inorder.begin(),find(inorder.begin(),inorder.end(),val));
        
        vector<int> preorder_left(preorder.begin()+1,preorder.begin()+index+1);
        vector<int> inorder_left(inorder.begin(),inorder.begin()+index);
        vector<int> preorder_right(preorder.begin()+index+1,preorder.end());
        vector<int> inorder_right(inorder.begin()+index+1,inorder.end());
        
        ans->left=buildTree(preorder_left,inorder_left);
        ans->right=buildTree(preorder_right,inorder_right);
        
        return ans;
    }
};