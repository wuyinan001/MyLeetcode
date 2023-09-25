class Solution:
    def splitArray(self, nums: List[int], m: int) -> int:
        n=len(nums)
        dp=[[inf for j in range(m)] for i in range(n)]
        
        dp[0][0]=nums[0]
        
        for i in range(1,n):
            dp[i][0]=dp[i-1][0]+nums[i]
            
        for j in range(1,m):
            for i in range(j,n):
                sum1=0
                for k in range(i,j-1,-1):
                    sum1+=nums[k]
                    dp[i][j]=min(dp[i][j],max(dp[k-1][j-1],sum1))
        
        return dp[n-1][m-1]