class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        
        int n=nums.length;
        
        if(n<3)
            return 0;
        
        boolean[][] dp=new boolean[n][n];
        
        int ans=0;
        
        for(int i=0;i<=n-3;i++)
        {
            if((nums[i+1]-nums[i])==(nums[i+2]-nums[i+1]))
            {
                dp[i][i+2]=true;
                ans++;
            }
        }
        
        for(int gap=3;gap<=n-1;gap++)
        {
            for(int i=0;i<n-gap;i++)
            {
                int j=i+gap;
                
                if(dp[i][j-1]&&(nums[j]-nums[j-1])==(nums[j-1]-nums[j-2]))
                {
                    dp[i][j]=true;
                    ans++;
                }
            }
        }
        
        return ans;
    }
}