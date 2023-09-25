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
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>> ans;
        if(root==NULL)
            return ans;
        
        vector<TreeNode*> queue;
        queue.push_back(root);
        
        while(!queue.empty())
        {
            int size=queue.size();
            vector<int> list;
            for(int i=0;i<size;i++)
            {
                TreeNode* node=queue[0];
                queue.erase(queue.begin());
                list.push_back(node->val);
                
                if(node->left)
                    queue.push_back(node->left);
                
                if(node->right)
                    queue.push_back(node->right);
            }
            
            ans.push_back(list);
        }
        
        return ans;
    }
};