class NumArray {
    
    int[] cumsum;

    public NumArray(int[] nums) {
        int n=nums.length;
        
        if(n!=0)
        {
            cumsum=new int[n];
            cumsum[0]=nums[0];
            for(int i=1;i<n;i++)
            {
                cumsum[i]=cumsum[i-1]+nums[i];
            }
        }     
    }
    
    public int sumRange(int i, int j) {
        if(i==0)
            return cumsum[j];
        else
            return cumsum[j]-cumsum[i-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */