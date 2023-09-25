class MedianFinder {
    
    PriorityQueue<Integer> pq1;
    PriorityQueue<Integer> pq2;
    
    
    /** initialize your data structure here. */
    public MedianFinder() {
        
       pq1=new PriorityQueue(new Comparator<Integer>(){

           public int compare(Integer a, Integer b)
           {
               return b-a;
           }

       });
        
        pq2=new PriorityQueue();
    }
    
    public void addNum(int num) {
 
        pq1.add(num);
        
        pq2.add(pq1.poll());
        
        if(pq2.size()>pq1.size())
            pq1.add(pq2.poll());
        
    }
    
    
    public double findMedian() {
        
        if(pq1.isEmpty())
            return 0.0;
        
        if(pq1.size()==pq2.size())
            return ((double)pq1.peek()+pq2.peek())/2;
        else
            return pq1.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */