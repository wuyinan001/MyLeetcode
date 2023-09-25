class LRUCache {

    private class Node
    {
        int key;
        int value;
        Node next;
        Node prev;
        
        public Node(int key, int val)
        {
            this.key=key;
            value=val;
        }
    }
    
    Map<Integer,Node> map;
    int cap;
    Node head;
    Node tail;
    
    public LRUCache(int capacity) {
        
        map=new HashMap();
        cap=capacity;
        
        head=new Node(-1,-1);
        tail=new Node(-2,-1);
        
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        
        if(!map.containsKey(key))
            return -1;
        else
        {
            Node curr=map.get(key);
            if(curr!=tail.prev)
            {
                curr.prev.next=curr.next;
                curr.next.prev=curr.prev;
                
                curr.prev=tail.prev;
                curr.next=tail;
                tail.prev.next=curr;
                tail.prev=curr;
            }
            
            return curr.value;
        }
    }
    
    public void put(int key, int value) {
        
        if(map.containsKey(key))
        {
            map.get(key).value=value;
            
            Node curr=map.get(key);
            if(curr!=tail.prev)
            {
                curr.prev.next=curr.next;
                curr.next.prev=curr.prev;
                
                curr.prev=tail.prev;
                curr.next=tail;
                tail.prev.next=curr;
                tail.prev=curr;
            }
        }
        else
        {
            if(cap==map.size())
            {
                Node del=head.next;
                map.remove(del.key);
                head.next=del.next;
                del.next.prev=head;
            }
            
            Node curr=new Node(key,value);
            curr.next=tail;
            curr.prev=tail.prev;
            tail.prev.next=curr;
            tail.prev=curr;
            
            map.put(key,curr);
        }
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */