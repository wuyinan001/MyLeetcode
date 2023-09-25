class LRUCache {
    
    Map<Integer,Integer> map;
    Queue<Integer> queue;
    int num;
    int size;

    public LRUCache(int capacity) {
        
        map=new HashMap();
        queue=new LinkedList();
        num=0;
        size=capacity;
        
    }
    
    public int get(int key) {
        
        if(!map.containsKey(key))
            return -1;
        else
        {
            int ans=map.get(key);
            queue.remove(key);
            queue.add(key);
            return ans;
        }
    }
    
    public void put(int key, int value) {
        
        if(map.containsKey(key))
        {
            map.put(key,value);
            queue.remove(key);
            queue.add(key);
        }
        else
        {
            if(num==size)
            {
                int remove_key=queue.remove();
                map.remove(remove_key);
                num--;
            }
            
            queue.add(key);
            map.put(key,value);
            
            num++;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */