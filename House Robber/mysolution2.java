class Solution {
    public int rob(int[] nums) {
        
        int n=nums.length;
        
        if(n==0)
            return 0;
        
        if(n==1)
            return nums[0];
        
        if(n==2)
            return Math.max(nums[0],nums[1]);
        
        // L[i]: max theft if ending at house i
        // when i>=3, L[i]=max(L[i-2]+nums[i],L[i-3]+nums[i]);
        int[] L=new int[n];
        
        L[0]=nums[0];
        L[1]=nums[1];
        L[2]=nums[2]+L[0];
        
        int max=Math.max(L[1],L[2]);
        
        for(int i=3;i<n;i++)
        {
            L[i]=Math.max(L[i-2]+nums[i],L[i-3]+nums[i]);
            
            if(max<L[i])
                max=L[i];
        }
        
        return max;
    }
}