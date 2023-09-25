/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        
        if(head==null)
            return null;
        
        Map<Node,Node> map=new HashMap<>();
        
        Node ans=new Node(head.val);
        map.put(head,ans);
        
        Node curr1=head.next;
        Node curr2=ans;
        
        
        
        while(curr1!=null)
        {
            curr2.next=new Node(curr1.val);
            map.put(curr1,curr2.next);
            curr1=curr1.next;
            curr2=curr2.next;
        }
        
        curr1=head;
        curr2=ans;
        
        while(curr1!=null)
        {
            curr2.random=map.get(curr1.random);
            curr1=curr1.next;
            curr2=curr2.next;
        }
        
        return ans;
    }
}