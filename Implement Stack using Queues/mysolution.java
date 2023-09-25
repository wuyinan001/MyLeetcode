class MyStack {
    
    // queue1 only keeps the last element or empty
    Queue<Integer> queue1;
    Queue<Integer> queue2;
    
    /** Initialize your data structure here. */
    public MyStack() {
        queue1=new LinkedList<>();
        queue2=new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        if(queue1.size()>=1)
            queue2.add(queue1.remove());
        queue1.add(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int result=queue1.remove();
        
        while(!queue2.isEmpty())
            queue1.add(queue2.remove());
        
        while(queue1.size()>1)
            queue2.add(queue1.remove());
        
        return result;
    }
    
    /** Get the top element. */
    public int top() {
        return queue1.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty()&&queue2.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */