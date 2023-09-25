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
    vector<int> toList(TreeNode* root)
    {
        if(root==NULL)
            return {};
        
        vector<int> ans;
        
        vector<int> left=toList(root->left);
        vector<int> right=toList(root->right);
        
        ans.insert(ans.end(),left.begin(),left.end());
        ans.push_back(root->val);
        ans.insert(ans.end(),right.begin(),right.end());
        
        return ans;
    }
    
    bool isValidBST(TreeNode* root) {
        vector<int> v=toList(root);
        
        int n=v.size();
        
        for(int i=0;i<n-1;i++)
        {
            if(v[i]>=v[i+1])
                return false;
        }
        
        return true;
    }
};