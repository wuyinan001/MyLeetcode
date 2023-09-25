class Solution:
    def minDistance(self, houses: List[int], k: int) -> int:
        n=len(houses)
        
        if n<=k:
            return 0
        
        houses.sort()
        dp=[[0 for j in range(k)] for i in range(n)]
        
        dp[0][0]=0
        total=0
        mail=0
        
        for h in range(1,n):
            total+=houses[h]-houses[mail]
            dp[h][0]=total
            if (h+1)%2==0:
                mail+=1
        
        for j in range(1,k):
            for i in range(j+1,n):
                total=0
                mail=i
                dp[i][j]=inf
                for h in range(i,j-1,-1):
                    total+=houses[mail]-houses[h]
                    dp[i][j]=min(dp[i][j],dp[h-1][j-1]+total)
                    if (i-h+1)%2==0:
                        mail-=1
        
        return dp[n-1][k-1]