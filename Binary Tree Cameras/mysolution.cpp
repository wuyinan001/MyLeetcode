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
    set<TreeNode*> cover{NULL};
    int count=0;
    
    void printTree(TreeNode* node)
    {
        if(node==NULL)
            cout<<"null,";
        else
        {
            cout<<node<<",";
            printTree(node->left);
            printTree(node->right);
        }
    }
    
    void dfs(TreeNode* node, TreeNode* parent)
    {
        if(cover.find(node)==cover.end())
        {
            dfs(node->left,node);
            dfs(node->right,node);
            
            if((cover.find(node->left)==cover.end())||(cover.find(node->right)==cover.end())\
                ||(parent==NULL&&cover.find(node)==cover.end()))
            {
                count++;
                cover.insert(parent);
                cover.insert(node);
                cover.insert(node->left);
                cover.insert(node->right);
                
                // cout<<"print cover:"<<endl;
                // for(auto i:cover)
                //     cout<<node<<" ";
                // cout<<endl;
            }
        }
    }
    
    int minCameraCover(TreeNode* root) {
        // if(cover.find(NULL)==cover.end())
        //     cout<<"null not exist";
        // else
        //     cout<<"null exists";
        // cout<<endl;
        
        // printTree(root);
        // cout<<endl;
        
        dfs(root,NULL);
        return count;
    }
};