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
    bool equal(TreeNode* t1, TreeNode* t2)
    {
        if(t1==NULL&&t2==NULL)
            return true;
        else if(t1==NULL||t2==NULL)
            return false;
        else
            return (t1->val==t2->val)&&equal(t1->left,t2->left)&&equal(t1->right,t2->right);
    }
    
    bool isSubtree(TreeNode* root, TreeNode* subRoot) {
        if(root==NULL&&subRoot==NULL)
            return true;
        else if(root==NULL||subRoot==NULL)
            return false;
        return equal(root,subRoot)||isSubtree(root->left,subRoot)||isSubtree(root->right,subRoot);
    }
};