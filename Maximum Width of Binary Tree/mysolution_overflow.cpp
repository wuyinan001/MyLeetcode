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
    int widthOfBinaryTree(TreeNode* root) {
        if(root==NULL)
            return 0;
        
        vector<pair<TreeNode*,int>> queue{{root,0}};
        int ans=0;
        
        while(!queue.empty())
        {
            int size=queue.size();
            int left=0, right=0;
            for(int i=0;i<size;i++)
            {
                pair<TreeNode*,int> curr=queue[0];
                queue.erase(queue.begin());
                if(i==0)
                    left=curr.second;
                else if(i==size-1)
                    right=curr.second;
                
                if(curr.first->left!=NULL)
                    queue.push_back({curr.first->left,curr.second*2});
                
                if(curr.first->right!=NULL)
                    queue.push_back({curr.first->right,curr.second*2+1});
            } 
            
            ans=max(ans,right-left+1);
        }
        
        return ans;
    }
};