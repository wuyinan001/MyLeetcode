class LRUCache {
    
    int cap;
    
    // The index 0 contains least recently used keys/values; The last index contains the most recently used keys/values;
    List<Integer> keys;
    List<Integer> values;
    
    public LRUCache(int capacity) {
        
        cap=capacity;
        keys=new ArrayList();
        values=new ArrayList();
        
    }
    
    public int get(int key) {
        
        if(!keys.contains(key))
            return -1;
        else
        {
            int index=keys.indexOf(key);
            int ans=values.get(index);
            
            //Move this key and value pair to the last(most recent) index
            keys.remove(index);
            keys.add(key);
            values.remove(index);
            values.add(ans);
            
            return ans;
        }
        
    }
    
    public void put(int key, int value) {
        
        if(keys.contains(key))
        {
            int index=keys.indexOf(key);
            keys.remove(index);
            keys.add(key);
            values.remove(index);
            values.add(value);
            
        }
        else
        {
            if(keys.size()<cap)
            {
                keys.add(key);
                values.add(value);
            }
            else
            {
                keys.remove(0);
                values.remove(0);
                keys.add(key);
                values.add(value);
            }
        }
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */