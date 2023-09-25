/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* reverse(ListNode* node)
    {
        if(node==NULL||node->next==NULL)
            return node;
        
        ListNode* tmp=node->next;
        node->next=NULL;
        ListNode* ans=reverse(tmp);
        tmp->next=node;
        
        return ans;
    }
    
    ListNode* merge(ListNode* l1, ListNode* l2)
    {
        bool odd=true;
        
        ListNode* prehead=new ListNode();
        ListNode* curr=prehead;
        
        while(l1!=NULL||l2!=NULL)
        {
            if(odd)
            {
                curr->next=l1;
                l1=l1->next;
                odd=false;
            }
            else
            {
                curr->next=l2;
                l2=l2->next;
                odd=true;
            }
            curr=curr->next;
        }
        
        return prehead->next;
    }
    
    void reorderList(ListNode* head) {
        
        ListNode* prehead=new ListNode();
        prehead->next=head;
        ListNode *slow=prehead, *fast=prehead;
        
        while(fast!=NULL&&fast->next!=NULL)
        {
            slow=slow->next;
            fast=fast->next->next;
        }
        
        ListNode* l2=slow->next;
        slow->next=NULL;
        l2=reverse(l2);
        
        head=merge(head,l2);
    }
};