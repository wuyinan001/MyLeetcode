class MaxStack {

    Stack<Integer> stack1;
    Stack<Integer> stack2;
    
    /** initialize your data structure here. */
    public MaxStack() {
        
        stack1=new Stack();
        stack2=new Stack();
    }
    
    public void push(int x) {
        
        stack1.push(x);
        if(stack2.isEmpty()||x>stack2.peek())
            stack2.push(x);
        else
            stack2.push(stack2.peek());
    }
    
    public int pop() {
        
        int ans=stack1.pop();
        
        stack2.pop();
        
        return ans;
    }
    
    public int top() {
        
        return stack1.peek();
    }
    
    public int peekMax() {
        
        return stack2.peek();
    }
    
    public int popMax() {
        
        Stack<Integer> buffer=new Stack();
        
        int ans=stack2.peek();
        
        while(stack1.peek()<ans)
        {
            buffer.push(pop());
        }
        
        pop();
        
        while(!buffer.isEmpty())
        {
            push(buffer.pop());
        }
        
        return ans;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */