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
    int ans=0;
    
    int dfs(TreeNode* node)
    {
        if(node!=NULL)
        {
            int left=dfs(node->left), right=dfs(node->right);
            ans+=abs(left+right+node->val-1);
            
            return left+right+node->val-1;
        }
        else
            return 0;
    }
    
    int distributeCoins(TreeNode* root) {
        dfs(root);
        return ans;
    }
};