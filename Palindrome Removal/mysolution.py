class Solution:
    def minimumMoves(self, arr: List[int]) -> int:
        n=len(arr)
        dp=[[1 for j in range(n)] for i in range(n)]
        
        for i in range(0,n-1):
            if arr[i]!=arr[i+1]:
                dp[i][i+1]=2
        
        for gap in range(2,n):
            for i in range(0,n-gap):
                j=i+gap
                dp[i][j]=inf
                if arr[i]==arr[j]:
                    dp[i][j]=dp[i+1][j-1]
                
                for k in range(i,j):
                    dp[i][j]=min(dp[i][j],dp[i][k]+dp[k+1][j])
        
        return dp[0][n-1]