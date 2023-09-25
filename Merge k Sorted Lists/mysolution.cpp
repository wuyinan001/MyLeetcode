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
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        priority_queue<int, vector<int>, greater<int>> pq;
        
        for(auto v:lists)
        {
            while(v)
            {
                pq.push(v->val);
                v=v->next;
            }
        }
        
        ListNode* prehead=new ListNode();
        ListNode* curr=prehead;
        
        while(pq.size()>0)
        {
            curr->next=new ListNode(pq.top());
            pq.pop();
            curr=curr->next;
        }
        
        return prehead->next;
    }
};