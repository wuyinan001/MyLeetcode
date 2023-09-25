/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        
        if(head==null)
        {
            Node ans=new Node(insertVal);
            ans.next=ans;
            return ans;
        }
        
        
        Node min=head, max=head;
        Node curr=head.next;
        
        while(curr!=head)
        {
            if(curr.val<=min.val)
                min=curr;
            
            if(curr.val>=max.val)
                max=curr;
            
            curr=curr.next;
        }
        
        if(insertVal<min.val||insertVal>=max.val)
        {
            Node temp=new Node(insertVal);
            temp.next=max.next;
            max.next=temp;
            
            return head;
        }
        else
        {
            curr=head;
            
            while(true)
            {
                if(insertVal>=curr.val&&insertVal<=curr.next.val)
                {
                    Node temp=new Node(insertVal);
                    temp.next=curr.next;
                    curr.next=temp;

                    return head;
                }
                
                curr=curr.next;
            }
        }
    }
}