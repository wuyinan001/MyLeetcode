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
    vector<int> toList(TreeNode* node)
    {
        vector<int> ans;
        
        if(node==NULL)
            return ans;
        
        vector<int> left=toList(node->left);
        vector<int> right=toList(node->right);
        
        ans.insert(ans.end(),left.begin(),left.end());
        ans.push_back(node->val);
        ans.insert(ans.end(),right.begin(),right.end());
        
        return ans;
    }
    
    int kthSmallest(TreeNode* root, int k) {
        vector<int> list=toList(root);
        return list[k-1];       
    }
};