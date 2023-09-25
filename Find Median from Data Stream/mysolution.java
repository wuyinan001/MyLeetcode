class MedianFinder {
    
    List<Integer> list;

    /** initialize your data structure here. */
    public MedianFinder() {
        
        list=new ArrayList<>();
    }
    
    public void addNum(int num) {
        
        if(list.isEmpty())
        {
            list.add(num);
            return;
        }
        
        int n=list.size();
        
        for(int i=0;i<n;i++)
        {
            if(num<list.get(i))
            {
                list.add(i,num);
                return;
            }
        }
        
        list.add(num);
    }
    
    public double findMedian() {
        
        int n=list.size();
        
        if(n==0)
            return 0.0;
        
        if(n%2==0)
            return ((double)list.get(n/2)+(double)list.get(n/2-1))/2;
        else
            return list.get(n/2);
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */