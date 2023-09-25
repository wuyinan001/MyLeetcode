class MyHashSet {
public:
    int size=100;
    vector<TreeNode*> array;
    
    MyHashSet() {
        for(int i=0;i<size;i++)
            array.push_back(new TreeNode(-1));
        
        // for(auto t:array)
        //     printTree(t);
    }
    
    TreeNode* add(int key, TreeNode* node)
    {
        if(key==node->val)
            return node;
        else if(key<node->val)
        {
            if(!node->left)
                node->left=new TreeNode(key);
            else
                node->left=add(key,node->left);
            
            return node;
        }
        else
        {
            if(!node->right)
                node->right=new TreeNode(key);
            else
                node->right=add(key,node->right);
            
            return node;
        }
    }
    
    void add(int key) {
        TreeNode* root=array[key%size]; 
        root=add(key,root);
    }
    
    TreeNode* min(TreeNode* node)
    {
        if(node->left==NULL)
            return node;
        else
            return min(node->left);
    }
    
    TreeNode* removeMin(TreeNode* node)
    {
        if(node->left==NULL)
            return node->right;
        else
        {
            node->left=removeMin(node->left);
            return node;
        }
    }
    
    TreeNode* remove(int key, TreeNode* node)
    {
        if(node==NULL)
            return NULL;
        
        if(key==node->val)
        {
            if(node->left==NULL)
            {
                return node->right;
            }
            else if(node->right==NULL)
            {
                return node->left;
            }
            else
            {
                TreeNode* t=node;
                node=min(t->right);
                node->right=removeMin(t->right);
                node->left=t->left;
                return node;
            }
        }
        else if(key<node->val)
        {
            node->left=remove(key,node->left);
            return node;
        }
        else
        {
            node->right=remove(key,node->right);
            return node;
        }
    }
    
    void remove(int key) {
        TreeNode* root=array[key%size]; 
        root=remove(key,root);
    }
    
//     void printTree(TreeNode* node)
//     {
//         if(!node)
//         {
//             cout<<"NULL ";
//             return;
//         }
            
//         cout<<node->val<<" ";
//         printTree(node->left);
//         printTree(node->right);
//     }
    
    bool contains(int key, TreeNode* node)
    {
        if(!node)
            return false;
        
        if(key==node->val)
            return true;
        else if(key<node->val)
            return contains(key,node->left);
        else
            return contains(key,node->right);
    }
    
    bool contains(int key) {
        TreeNode* root=array[key%size];
        // cout<<"Print tree in bucket "<<(key%size)<<" "<<endl;
        // printTree(root);
        // cout<<endl;
        return contains(key,root);
    }
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */