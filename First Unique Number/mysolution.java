class FirstUnique {

    private Queue<Integer> queue=new LinkedList();
    private Map<Integer,Integer> map=new HashMap();
    
    public FirstUnique(int[] nums) {
        
        for(int i:nums)
        {
            queue.add(i);
            map.put(i,map.getOrDefault(i,0)+1);
        }
    }
    
    public int showFirstUnique() {
        
        while(!queue.isEmpty())
        {
            int temp=queue.peek();
            if(map.get(temp)==1)
                return temp;
            else
                queue.remove();
        }
        
        return -1;
    }
    
    public void add(int value) {
        
        queue.add(value);
        map.put(value,map.getOrDefault(value,0)+1);
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */