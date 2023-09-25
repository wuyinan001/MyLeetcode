class MyLinkedList {
    
    private Node first;
    private Node last;
    private int size;
    
    private class Node
    {
        private int val;
        private Node next;
        
        public Node(int v)
        {
            val=v;
        }
    }

    /** Initialize your data structure here. */
    public MyLinkedList() {
        
        first=null;
        size=0;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        
        if(index>size-1||index<0)
                return -1;
            
            Node curr=first;
            
            for(int i=0;i<index;i++)
            {
                curr=curr.next;
            }
            
            return curr.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        
        size++;
        Node temp=new Node(val);
        temp.next=first;
        first=temp;

        if(last==null)
            last=temp;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        
        size++;
        if(last==null)
        {
            last=new Node(val);
            first=last;
        }
        else
        {
            last.next=new Node(val);
            last=last.next;
        }
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        
        if(index>size||index<0)
                return;

        if(size==0)
        {
            first=new Node(val);
            last=first;
            size++;
            return;
        }

        if(index==0)
        {
            Node temp=new Node(val);
            temp.next=first;
            first=temp;
        }
        else if(index==size)
        {
            last.next=new Node(val);
            last=last.next;
        }
        else
        {
            Node curr=first;

            for(int i=0;i<index-1;i++)
            {
                curr=curr.next;
            }

            Node temp=new Node(val);
            temp.next=curr.next;
            curr.next=temp;
        }

        size++;
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index<0||index>=size)
                return;

        if(size==1)
        {
            first=null;
            last=null;
            size--;
            return;
        }

        if(index==size-1)
        {
            Node curr=first;

            for(int i=0;i<index-1;i++)
                curr=curr.next;

            curr.next=null;
            last=curr;
        }
        else if(index==0)
        {
            first=first.next;
        }
        else
        {
            Node curr=first;

            for(int i=0;i<index-1;i++)
                curr=curr.next;

            curr.next=curr.next.next;
        }

        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */