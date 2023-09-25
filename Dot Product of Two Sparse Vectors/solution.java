class SparseVector {
    
    Map<Integer,Integer> mapping;
    
    SparseVector(int[] nums) {
        
        mapping=new HashMap();
        
        for(int i=0;i<nums.length;i++)
            if(nums[i]!=0)
                mapping.put(i,nums[i]);
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        
        int sum=0;
        
        for(Integer i:this.mapping.keySet())
            if(vec.mapping.containsKey(i))
                sum+=this.mapping.get(i)*vec.mapping.get(i);
        
        return sum;
    }
}