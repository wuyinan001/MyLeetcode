/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        
        Node[] ans=flattenNode(head);
        
        return ans[0];
        
    }
    
    private Node[] flattenNode(Node head)
    {
        if(head==null)
            return new Node[2];
        
        Node[] ans=new Node[2];
        
        Node curr=head,last=null;
        
        while(curr!=null)
        {
            if(curr.child!=null)
            {
                Node[] temp=flattenNode(curr.child);
                curr.child=null;
                Node save=curr.next;
                curr.next=temp[0];
                temp[0].prev=curr;
                temp[1].next=save;
                
                if(save!=null)
                    save.prev=temp[1];
                else
                    last=temp[1];
                
                curr=save;
            }
            else
            {
                if(curr.next==null)
                    last=curr;
                
                curr=curr.next;
            }
                
        }
        
        ans[0]=head;
        ans[1]=last;
        
        return ans;
    }
}