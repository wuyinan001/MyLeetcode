class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        
        if(n==0)
            return 0;
        
        // L[i] has max of LIS including nums[i]
        int[] L=new int[n];
        
        L[0]=1;
        int max=1;
        
        for(int i=1;i<n;i++)
        {   
            L[i]=1;
            
            for(int j=0;j<i;j++)
            {
                if(nums[j]<nums[i]&&L[i]<L[j]+1)
                    L[i]=L[j]+1;
            }
            
            if(max<L[i])
                max=L[i];
        }
        
        return max;
    }
}