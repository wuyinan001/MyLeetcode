class Solution {
    
    int n;
    
    private int dp(int[] nums, int index, int sumL, int sumR, Integer[][] memo)
    {
        if(index==n)
            return Math.abs(sumL-sumR);
        
        if(memo[index][sumL]!=null)
            return memo[index][sumL];
        
        memo[index][sumL]=Math.min(dp(nums,index+1,sumL+nums[index],sumR,memo),dp(nums,index+1,sumL,sumR+nums[index],memo));
        
        return memo[index][sumL];
    }
    
    public boolean canPartition(int[] nums) {
        
        n=nums.length;
        
        int sum=0;
        
        for(int i:nums)
            sum+=i;
        
        Integer[][] memo=new Integer[n][sum+1];
        
        return dp(nums,0,0,0,memo)==0;
    }
}