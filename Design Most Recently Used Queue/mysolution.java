class MRUQueue {
    
    class Node
    {
        int val;
        Node next;
        Node prev;
        
        public Node(int val)
        {
            this.val=val;
            next=null;
            prev=null;
        }
    }
    
    Node head;
    Node tail;
    
    private void addNode(Node curr)
    {
        curr.next=tail;
        curr.prev=tail.prev;
        curr.prev.next=curr;
        tail.prev=curr;
    }
    
    private void removeNode(Node curr)
    {
        curr.next.prev=curr.prev;
        curr.prev.next=curr.next;
        curr.prev=null;
        curr.next=null;
    }
    
    private void print(Node node)
    {
        Node curr=node;
        
        while(curr!=null)
        {
            System.out.print(curr.val+"->");
            curr=curr.next;
        }
            
        System.out.println();
    }
    
    public MRUQueue(int n) {
        
        head=new Node(0);
        tail=new Node(0);
        
        head.next=tail;
        tail.prev=head;
        
        for(int i=1;i<=n;i++)
        {
            addNode(new Node(i));
        }
        
        //print(head);
    }
    
    public int fetch(int k) {
        
        Node curr=head;
        
        for(int i=1;i<=k;i++)
        {
            curr=curr.next;
        }
        
        removeNode(curr);
        addNode(curr);
        
        return curr.val;
    }
}

/**
 * Your MRUQueue object will be instantiated and called as such:
 * MRUQueue obj = new MRUQueue(n);
 * int param_1 = obj.fetch(k);
 */