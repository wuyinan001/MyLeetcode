class Solution {
    public boolean canPartition(int[] nums) {
        
        int sum=0;
        
        for(int i:nums)
            sum+=i;
        
        if(sum%2!=0)
            return false;
        
        int half_sum=sum/2;
        int n=nums.length;
        
        // memo[i][j]: whether it is possible to sum to j by choosing subsets from nums[0] to nums[i]
        Boolean[][] memo=new Boolean[n][half_sum+1];
        
        return dp(nums,n-1,half_sum,memo);
    }
    
    private boolean dp(int[] nums, int i, int sum, Boolean[][] memo)
    {
        if(sum==0)
            return true;
        
        if(i==-1||sum<0)
            return false;
        
        if(memo[i][sum]!=null)
            return memo[i][sum];
        
        boolean result=dp(nums,i-1,sum-nums[i],memo)||dp(nums,i-1,sum,memo);
        
        memo[i][sum]=result;
        return  result;
    }
}