class Solution {
    public int rob(int[] nums) {
        
        int n=nums.length;
        
        if(n==1)
            return nums[0];
        
        return Math.max(rob(nums,0,n-2),rob(nums,1,n-1));
        
    }
    
    private int rob(int[] nums, int start, int end)
    {
        if(start>end)
            return 0;
        
        if(start==end)
            return nums[start];
        
        if(end==start+1)
            return Math.max(nums[start],nums[end]);
        
        
        int[] L=new int[end-start+1];
        
        L[0]=nums[start];
        L[1]=nums[start+1];
        L[2]=nums[start+2]+L[0];
        
        int max=Math.max(L[1],L[2]);
        
        for(int i=3;i<=end-start;i++)
        {
            L[i]=Math.max(L[i-2]+nums[i+start],L[i-3]+nums[i+start]);
            
            if(max<L[i])
                max=L[i];
        }
        
        return max;
    }
}
