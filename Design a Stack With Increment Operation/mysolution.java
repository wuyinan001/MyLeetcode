class CustomStack {
    
    int capacity;
    int count;
    List<Integer> list;
    
    public CustomStack(int maxSize) {
        
        capacity=maxSize;
        count=0;
        list=new ArrayList();
    }
    
    public void push(int x) {
        
        if(count<capacity)
        {
            list.add(x);
            count++;
        }
    }
    
    public int pop() {
        
        if(count==0)
            return -1;
        
        int ans=list.remove(count-1);
        count--;
        
        return ans;
        
    }
    
    public void increment(int k, int val) {
        
        if(k>=count)
            for(int i=0;i<count;i++)
                list.set(i,val+list.get(i));
        else
            for(int i=0;i<k;i++)
                list.set(i,val+list.get(i));
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */