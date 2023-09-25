class MyHashMap {

    List<Integer> keyList;
    List<Integer> valList;
    
    /** Initialize your data structure here. */
    public MyHashMap() {
        
        keyList=new ArrayList();
        valList=new ArrayList();
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        
        if(keyList.contains(key))
        {
            int index=keyList.indexOf(key);
            valList.set(index,value);
        }
        else
        {
            keyList.add(key);
            valList.add(value);
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        
        if(keyList.contains(key))
        {
            int index=keyList.indexOf(key);
            return valList.get(index);
        }
        else
            return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        
        if(keyList.contains(key))
        {
            int index=keyList.indexOf(key);
            keyList.remove(index);
            valList.remove(index);
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */