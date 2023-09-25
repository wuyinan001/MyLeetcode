class Solution {
    public int combinationSum4(int[] nums, int target) {
        
        // dp[i]: how many permutations to get sum equal to i
        int[] dp=new int[target+1];
        
        dp[0]=1;
        
        for(int i=1;i<=target;i++)
        {
            for(int j:nums)
            {
                // Suppose the num j is at the bottom of the permutation
                if(j<=i)
                    dp[i]+=dp[i-j];
            }
        }
        
        return dp[target];
    }
}