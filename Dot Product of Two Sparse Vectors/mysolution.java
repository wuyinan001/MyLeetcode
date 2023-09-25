class SparseVector {
    
    int[] values;
    int size;
    
    SparseVector(int[] nums) {
        
        int n=nums.length;
        this.size=n;
        values=new int[n];
        
        for(int i=0;i<size;i++)
            values[i]=nums[i];
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        
        int sum=0;
        
        for(int i=0;i<size;i++)
            sum+=values[i]*vec.values[i];
        
        return sum;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);