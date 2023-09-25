class LFUCache {
    
    // Map Key: 0: Value; 1: Frequency; 2: Most recently time used
    Map<Integer,int[]> map;
    PriorityQueue<Integer> pq;
    
    int cap;
    int count;
    int time;
    
    public LFUCache(int capacity) {
        
        map=new HashMap();
        pq=new PriorityQueue(new Comparator<Integer>(){
            
            public int compare(Integer a1, Integer a2)
            {
                if(map.get(a1)[1]==map.get(a2)[1])
                    return map.get(a1)[2]-map.get(a2)[2];
                
                return map.get(a1)[1]-map.get(a2)[1];
            }
            
        });
        
        cap=capacity;
        count=0;
        time=0;
    }
    
    public int get(int key) {
        
        time++;
        
        if(map.containsKey(key))
        {
            map.get(key)[1]++;
            map.get(key)[2]=time;
            
            pq.remove(key);
            pq.add(key);
            
            return map.get(key)[0];
        }
        else
            return -1;
    }
    
    public void put(int key, int value) {
        
        time++;
        
        if(cap==0)
            return;
        
        if(map.containsKey(key))
        {
            map.get(key)[0]=value;
            map.get(key)[1]++;
            map.get(key)[2]=time;
            
            pq.remove(key);
            pq.add(key);
        }
        else
        {
            if(count==cap)
            {
                int key_remove=pq.poll();
                map.remove(key_remove);
                
                map.put(key,new int[]{value,1,time});
                pq.add(key);
                
            }
            else
            {
                count++;
                
                map.put(key,new int[]{value,1,time});
                pq.add(key);
            }
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */