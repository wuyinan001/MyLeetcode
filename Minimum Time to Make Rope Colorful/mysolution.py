class Solution:
    def minCost(self, colors: str, neededTime: List[int]) -> int:
        n=len(colors)
        
        dp=[float('inf') for _ in range(n)]
        
        dp[0]=0
        
        # presum[i+1]-presum[j]: sum from j to i
        presum=[0 for i in range(n+1)]
        
        for i in range(1,n+1):
            presum[i]=presum[i-1]+neededTime[i-1]
            
        prev=(colors[0],0)
        
        for i in range(1,n):
            if prev[0]==colors[i]:
                if prev[1]==0:
                    dp[i]=min(dp[i-1]+neededTime[i],presum[i]-presum[prev[1]])
                else:
                    dp[i]=min(dp[i-1]+neededTime[i],presum[i]-presum[prev[1]]+dp[prev[1]-1])
            else:
                dp[i]=dp[i-1]
            
            if colors[i]!=prev[0]:
                prev=(colors[i],i)
        
        return dp[n-1]