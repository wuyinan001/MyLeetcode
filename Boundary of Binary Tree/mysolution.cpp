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
    bool isLeaf(TreeNode* node)
    {
        if(node==NULL)
            return false;
        else
            return node->left==NULL&&node->right==NULL;
    }
    
    vector<int> leftBound(TreeNode* node)
    {
        vector<int> ans;
        if(node==NULL||isLeaf(node))
            return ans;
        
        ans.push_back(node->val);
        
        if(node->left!=NULL)
        {
            vector<int> v_prime=leftBound(node->left);
            ans.reserve(ans.size() + distance(v_prime.begin(),v_prime.end()));
            ans.insert(ans.end(),v_prime.begin(),v_prime.end());
        }
        else
        {
            vector<int> v_prime=leftBound(node->right);
            ans.reserve(ans.size() + distance(v_prime.begin(),v_prime.end()));
            ans.insert(ans.end(),v_prime.begin(),v_prime.end());
        }
        
        return ans;
    }
    
    vector<int> rightBound(TreeNode* node)
    {
        vector<int> ans;
        if(node==NULL||isLeaf(node))
            return ans;
        
        ans.push_back(node->val);
        
        if(node->right!=NULL)
        {
            vector<int> v_prime=rightBound(node->right);
            ans.reserve(ans.size() + distance(v_prime.begin(),v_prime.end()));
            ans.insert(ans.end(),v_prime.begin(),v_prime.end());
        }
        else
        {
            vector<int> v_prime=rightBound(node->left);
            ans.reserve(ans.size() + distance(v_prime.begin(),v_prime.end()));
            ans.insert(ans.end(),v_prime.begin(),v_prime.end());
        }
        
        return ans;
    }
    
    vector<int> bottomBound(TreeNode* node)
    {
        vector<int> ans;
        
        if(node==NULL)
            return ans;

        if(isLeaf(node))
        {
            ans.push_back(node->val);
            return ans;
        }
        
        vector<int> v1=bottomBound(node->left);
        vector<int> v2=bottomBound(node->right);
        
        ans.reserve(ans.size()+distance(v1.begin(),v1.end()));
        ans.insert(ans.end(),v1.begin(),v1.end());
        ans.reserve(ans.size()+distance(v2.begin(),v2.end()));
        ans.insert(ans.end(),v2.begin(),v2.end());
        
        return ans;
    }
    
    vector<int> boundaryOfBinaryTree(TreeNode* root) {
        vector<int> ans;
        
        if(root==NULL)
            return ans;
        else if(isLeaf(root))
        {
            ans.push_back(root->val);
            return ans;
        }
        
        ans.push_back(root->val);
        
        vector<int> left=leftBound(root->left);
        vector<int> right=rightBound(root->right);
        reverse(right.begin(),right.end());
        vector<int> bottom=bottomBound(root);
        
        ans.reserve(ans.size()+distance(left.begin(),left.end()));
        ans.insert(ans.end(),left.begin(),left.end());
        ans.reserve(ans.size()+distance(bottom.begin(),bottom.end()));
        ans.insert(ans.end(),bottom.begin(),bottom.end());
        ans.reserve(ans.size()+distance(right.begin(),right.end()));
        ans.insert(ans.end(),right.begin(),right.end());
        
        return ans;
    }
};