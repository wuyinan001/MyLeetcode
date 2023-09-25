class Skiplist {

    private class Node
    {
        int val;
        Node next;
        Node down;
        
        public Node(int val, Node next, Node down)
        {
            this.val=val;
            this.next=next;
            this.down=down;
        }
    }
    
    Node head;
    Random rand;
    
    public Skiplist() {
        
        head=new Node(-1,null,null);
        rand=new Random();
    }
    
    public boolean search(int target) {
        
        Node curr=head;
        
        while(curr!=null)
        {
            while(curr.next!=null&&curr.next.val<target)
                curr=curr.next;
            
            if(curr.next!=null&&curr.next.val==target)
                return true;
            
            curr=curr.down;
        }
        
        return false;
    }
    
    public void add(int num) {
        
        Stack<Node> stack=new Stack();
        boolean insert=true;
        
        Node curr=head;
        
        while(curr!=null)
        {
            while(curr.next!=null&&curr.next.val<num)
            {
                curr=curr.next;
            }
            
            stack.push(curr);
            
            curr=curr.down;
        }
        
        Node down=null;
        
        while(insert&&!stack.isEmpty())
        {
            curr=stack.pop();
            Node temp=new Node(num,curr.next,down);
            curr.next=temp;
            down=temp;
            
            insert= rand.nextDouble()>0.5;
        }
    }
    
    public boolean erase(int num) {
        
        Node curr=head;
        boolean ans=false;
        
        while(curr!=null)
        {
            while(curr.next!=null&&curr.next.val<num)
                curr=curr.next;
            
            if(curr.next!=null&&curr.next.val==num)
            {
                curr.next=curr.next.next;
                ans=true;
            }
            
            curr=curr.down;
        }
        
        return ans;
    }
}

/**
 * Your Skiplist object will be instantiated and called as such:
 * Skiplist obj = new Skiplist();
 * boolean param_1 = obj.search(target);
 * obj.add(num);
 * boolean param_3 = obj.erase(num);
 */