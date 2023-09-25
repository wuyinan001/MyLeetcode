class Solution:
    def numWays(self, steps: int, arrLen: int) -> int:
        n=min((int)(steps/2)+1,arrLen)
        dp=[[0 for j in range(n)] for i in range(steps+1)]
        MOD=(int)(1e9+7)
        dp[0][0]=1
        
        for i in range(1,steps+1):
            for j in range(n):
                if j==0 and j==n-1:
                    dp[i][j]=dp[i-1][j]
                elif j==0:
                    dp[i][j]=(dp[i-1][j+1]+dp[i-1][j])%MOD
                elif j==n-1:
                    dp[i][j]=(dp[i-1][j-1]+dp[i-1][j])%MOD
                else:
                    dp[i][j]=(dp[i-1][j+1]+dp[i-1][j]+dp[i-1][j-1])%MOD
        
        return dp[steps][0]