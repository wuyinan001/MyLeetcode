class Solution {
    
    int n;
    
    public int minSpaceWastedKResizing(int[] nums, int k) {
        
        n=nums.length;
        
        if(k>=n-1)
            return 0;
        
        Integer[][] memo=new Integer[n][k+1];
        return dp(nums,0,k,memo);
    }
    
    // dp: the min wasted space in nums[index...n-1] by resizing k times
    private int dp(int[] nums, int index, int k, Integer[][] memo)
    {
        if(index==n)
            return 0;
        
        if(k==-1)
            return (int)(1e9);
        
        if(memo[index][k]!=null)
            return memo[index][k];
        
        int ans=Integer.MAX_VALUE;
        int max=0, wasted=0, sum=0;
        
        for(int i=index;i<n;i++)
        {
            max=Math.max(max,nums[i]);
            sum+=nums[i];
            wasted=max*(i-index+1)-sum;
            
            ans=Math.min(ans,wasted+dp(nums,i+1,k-1,memo));
        }
        
        memo[index][k]=ans;
        return ans;
    }
}