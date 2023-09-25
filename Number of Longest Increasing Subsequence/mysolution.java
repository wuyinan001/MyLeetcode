class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n=nums.length;
        
        if(n==0)
            return 0;
        
        // L[i] contains length of longest increasing subsequence ending at i
        int[] L=new int[n];
        
        L[0]=1;
        
        int max=1;
        
        for(int i=1;i<n;i++)
        {
            L[i]=1;
            
            for(int j=0;j<i;j++)
            {
                if(nums[j]<nums[i]&&L[i]<(1+L[j]))
                    L[i]=1+L[j];
            }
            
            if(max<L[i])
                max=L[i];
        }
        
        // C[i] counts how many increasing subsequences ending at i
        int[] C=new int[n];
        int count=0;
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(L[j]==L[i]-1&&nums[j]<nums[i])
                    C[i]=C[i]+C[j];
            }
            
            if(C[i]==0)
                C[i]++;
            
            if(L[i]==max)
                count=count+C[i];
        }
        
        return count;
    }
}