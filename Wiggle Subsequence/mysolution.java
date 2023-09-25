class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n=nums.length;
        
        if(n==0)
            return 0;
        
        if(n==1)
            return 1;
        
        // L[i] holds the length of longest wiggle sequence ends at nums[i]
        int[] L=new int[n];
        
        // C[i] is 1 if the longest wiggle sequence ending at nums[i] is increasing;
        // -1 if the the longest wiggle sequence ending at nums[i] is decreasing;
        // 0 if the longest wiggle sequence ending at nums[i] has length of 1;
        
        int[] C=new int[n];
        
        int max=1;
        
        L[0]=1;
        
        if(nums[1]==nums[0])
        {
            L[1]=1;
        }
        else if(nums[1]>nums[0])
        {
            C[1]=1;
            L[1]=2;
            max=2;
        }
        else
        {
            C[1]=-1;
            L[1]=2;
            max=2;
        }
        
        for(int i=1;i<n;i++)
        {
            L[i]=1;
            
            for(int j=0;j<i;j++)
            {
                if(C[j]==0)
                {
                    if(nums[i]!=nums[j]&&L[i]<L[j]+1)
                    {
                        L[i]=L[j]+1;
                        if(nums[i]>nums[j])
                            C[i]=1;
                        else
                            C[i]=-1;
                    }
                }
                else if(C[j]>0)
                {
                    if(nums[i]<nums[j]&&L[i]<L[j]+1)
                    {
                        L[i]=L[j]+1;
                        C[i]=-1;
                    }       
                }
                else
                {
                    if(nums[i]>nums[j]&&L[i]<L[j]+1)
                    {
                        L[i]=L[j]+1;
                        C[i]=1;
                    }
                }
            }
            
            if(max<L[i])
                max=L[i];
        }
        
        return max;
    }
}