class Solution:
    def numRollsToTarget(self, d: int, f: int, target: int) -> int:
        
        MOD=int(1e9+7)
        dp=[[0 for j in range(target+1)] for i in range(d+1)]
        
        dp[0][0]=1
        
        for i in range(1,d+1):
            for j in range(1,target+1):
                for k in range(1,min(j,f)+1):
                    dp[i][j]=(dp[i][j]+dp[i-1][j-k])%MOD
        
        return dp[d][target]