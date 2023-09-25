// class ListNode
// {
// public:
//     int val;
//     ListNode* next;
    
//     ListNode(int val)
//     {
//         this->val=val;
//         next=NULL;
//     }
// };

class MyHashSet {
public:
    vector<ListNode*> array;
    int size=100;
    
    MyHashSet() {
        for(int i=0;i<size;i++)
        {
            array.push_back(new ListNode(-1));
        }
        // for(auto i:array)
        // {
        //     cout<<i<<" ";
        // }
        // cout<<endl;
    }
    
    void add(int key) {
        ListNode* curr=array[key%size];
        
        while(curr->next)
        {
            if(curr->next->val==key)
                return;
            curr=curr->next;
        }
        
        if(curr->val==key)
            return;
        curr->next=new ListNode(key);
    }
    
    void remove(int key) {
        ListNode* curr=array[key%size];
        
        while(curr->next)
        {
            if(curr->next->val==key)
            {
                curr->next=curr->next->next;
                return;
            }
            curr=curr->next;
        }
    }
    
    bool contains(int key) {
        ListNode* curr=array[key%size];
        
        while(curr)
        {
            if(curr->val==key)
                return true;
            curr=curr->next;
        }
        
        return false;
    }
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */