class Node
{
public:
    int val=-1;
    Node* next=NULL;
    Node* down=NULL;
    
    Node()
    {
        val=-1;
        next=NULL;
        down=NULL;
    }
    
    Node(int val)
    {
        this->val=val;
        next=NULL;
        down=NULL;
    }
};

class Skiplist {
public:
    Node* head;
    Skiplist() {
        head=new Node();
        //cout<<(head!=NULL)<<endl;
    }
    
    bool search(int target) {
        Node* curr=head;
        while(curr)
        {
            while(curr->next&&curr->next->val<target)
            {
                curr=curr->next;
            }
            
            if(curr->next&&curr->next->val==target)
                return true;
            else
                curr=curr->down;
        }
        return false;
    }
    
    void add(int num) {
        bool inserted=true;
        vector<Node*> stack;
        Node* curr=head;
        
        while(curr)
        {
            while(curr->next&&curr->next->val<num)
            {
                curr=curr->next;
            }
            
            stack.push_back(curr);
            curr=curr->down;
        }
        
        Node* down;
        while(!stack.empty()&&inserted)
        {
            Node* node=stack.back();
            stack.pop_back();
            Node* newNode=new Node(num);
            newNode->next=node->next;
            newNode->down=down;
            node->next=newNode;
            down=newNode;
            inserted=((double)rand()-(RAND_MAX))>0.5;
        }
        
        if(inserted)
        {
            Node* newNode=new Node(num);
            newNode->down=down;
            Node* newHead=new Node();
            newHead->next=newNode;
            newHead->down=head;
            head=newHead;
        }
    }
    
    bool erase(int num) {
        Node* curr=head;
        bool ans=false;
        while(curr)
        {
            while(curr->next&&curr->next->val<num)
            {
                curr=curr->next;
            }
            
            if(curr->next&&curr->next->val==num)
            {
                ans=true;
                curr->next=curr->next->next;
            }
            curr=curr->down;
        }
        return ans;
    }
};

/**
 * Your Skiplist object will be instantiated and called as such:
 * Skiplist* obj = new Skiplist();
 * bool param_1 = obj->search(target);
 * obj->add(num);
 * bool param_3 = obj->erase(num);
 */