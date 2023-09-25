class TwoSum {

    Map<Integer,Integer> map;
    
    /** Initialize your data structure here. */
    public TwoSum() {
        
        map=new HashMap();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        
        map.put(number,map.getOrDefault(number,0)+1);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        
        for(int key:map.keySet())
        {
            if(key*2==value)
            {
                if(map.get(key)>1)
                    return  true;
            }
            else
            {
                if(map.containsKey(value-key))
                    return true;
            }
            
        }
        
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */