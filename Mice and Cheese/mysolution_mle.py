class Solution:
    def miceAndCheese(self, reward1: List[int], reward2: List[int], k: int) -> int:
        n=len(reward1)
        
        # dp[i][j]: the maximum total from type 0 to type i when mouse 1 eats j cheeses
        dp=[[0 for _ in range(k+1)] for _ in range(n)]
        
        sum1=0
        for j in range(k):
            sum1+=reward1[j]
            dp[j][j+1]=sum1
        
        sum1=0
        for i in range(n):
            sum1+=reward2[i]
            dp[i][0]=sum1
            
        for j in range(1,k+1):
            for i in range(j,n):
                dp[i][j]=max(dp[i-1][j-1]+reward1[i],dp[i-1][j]+reward2[i])
        
        return dp[n-1][k]