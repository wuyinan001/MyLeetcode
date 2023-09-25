class TimeMap {

    Map<String,List<Pair<Integer,String>>> map;
    int time;
    
    /** Initialize your data structure here. */
    public TimeMap() {
        
        map=new HashMap();
        time=0;
    }
    
    public void set(String key, String value, int timestamp) {
        
        if(!map.containsKey(key))
        {
            map.put(key,new ArrayList());
        }
        
        map.get(key).add(new Pair(timestamp,value));
    }
    
    public String get(String key, int timestamp) {
        
        if(!map.containsKey(key))
            return "";
        else
        {
            List<Pair<Integer,String>> list=map.get(key);
            
            for(int i=list.size()-1;i>=0;i--)
            {
                if(list.get(i).getKey()<=timestamp)
                    return list.get(i).getValue();
                else
                    continue;
            }
            
            return "";
        }
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */