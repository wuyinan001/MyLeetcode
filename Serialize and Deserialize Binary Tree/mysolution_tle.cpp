/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Codec {
public:

    // Encodes a tree to a single string.
    string serialize(TreeNode* root) {
        string ans="";
        
        if(root==NULL)
        {
            ans=ans+"null,";
        }
        else
        {
            ans=ans+to_string(root->val)+",";
            ans=ans+serialize(root->left);
            ans=ans+serialize(root->right);
        }
        
        return ans;
    }

    // Decodes your encoded data to tree.
    TreeNode* deserialize(vector<string>& list)
    {
        if(list[0]=="null")
        {
            list.erase(list.begin());
            return NULL;
        }

        TreeNode* ans=new TreeNode(stoi(list[0]));
        
        list.erase(list.begin());
        
        ans->left=deserialize(list);
        ans->right=deserialize(list);
        
        return ans;
    }
    
    
    TreeNode* deserialize(string data) {
        //cout<<data<<endl;
        vector<string> list;
        
        stringstream ss(data);
        string word;
        
        while(!ss.eof())
        {
            getline(ss,word,',');
            list.push_back(word);
        }
        
        // cout<<"list"<<endl;
        // for(auto s:list)
        //     cout<<s<<" ";
        // cout<<endl;
        
        return deserialize(list);
    }
};

// Your Codec object will be instantiated and called as such:
// Codec ser, deser;
// TreeNode* ans = deser.deserialize(ser.serialize(root));