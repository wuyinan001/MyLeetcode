class RandomizedCollection {

    // Map contains the list of index of each val in ascending order
    Map<Integer,List<Integer>> map;
    List<Integer> list;
    
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        
        map=new HashMap();
        list=new ArrayList();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        
        boolean ans=false;
        
        if(!map.containsKey(val))
        {
            ans=true;
            list.add(val);
            map.put(val,new ArrayList());
            map.get(val).add(list.size()-1);
        }
        else
        {
            list.add(val);
            map.get(val).add(list.size()-1);
        }
        
        return ans;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        
        if(!map.containsKey(val))
            return false;
        else
        {
            if(map.get(val).size()==1)
            {
                int index=map.get(val).get(0);
                int lastIndex=list.size()-1;
                
                int val_replace=list.get(lastIndex);
                list.set(index,val_replace);
                int val_replace_list_lastIndex=map.get(val_replace).size()-1;
                map.get(val_replace).set(val_replace_list_lastIndex,index);
                Collections.sort(map.get(val_replace));
                
                list.remove(lastIndex);
                map.remove(val);
            }
            else
            {
                int val_list_lastIndex=map.get(val).size()-1;
                int index=map.get(val).get(val_list_lastIndex);
                int lastIndex=list.size()-1;
                
                int val_replace=list.get(lastIndex);
                list.set(index,val_replace);
                int val_replace_list_lastIndex=map.get(val_replace).size()-1;
                map.get(val_replace).set(val_replace_list_lastIndex,index);
                Collections.sort(map.get(val_replace));
                
                list.remove(lastIndex);
                map.get(val).remove(val_list_lastIndex);
            }
            
            
            return true;
        }
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        
        return list.get((int)(Math.random()*list.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */