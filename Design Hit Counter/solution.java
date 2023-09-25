class HitCounter {
    
    Queue<Integer> queue;
    
    /** Initialize your data structure here. */
    public HitCounter() {
        
        queue=new LinkedList();
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        
        queue.add(timestamp);
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        
        while(!queue.isEmpty())
        {
            int diff=timestamp-queue.peek();
            
            if(diff>=300)
                queue.remove();
            else
                break;
        }
        
        return queue.size();
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */