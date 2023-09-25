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
    TreeNode* red=NULL;
    
    int count(TreeNode* node)
    {
        if(node==NULL)
            return 0;
        
        return 1+count(node->left)+count(node->right);
    }
    
    void findRed(TreeNode* root, int x)
    {
        if(root==NULL)
            return;
        
        if(root->val==x)
        {
            red=root;
            return;
        }
        
        findRed(root->left,x);
        findRed(root->right,x);
    }
    
    bool btreeGameWinningMove(TreeNode* root, int n, int x) {
        findRed(root,x);
        
        int left=count(red->left), right=count(red->right);
        int other=n-1-left-right;
        
        return (left>n-left)||(right>n-right)||(other>n-other);
    }
};