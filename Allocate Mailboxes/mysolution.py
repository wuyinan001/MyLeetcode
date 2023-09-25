import numpy as np

class Solution:
    def minDistance(self, houses: List[int], k: int) -> int:
        n=len(houses)
        if n<=k:
            return 0
        
        dp=np.zeros((n,k),dtype=int)

        houses.sort()
        
        dist=0
        mail=0
        
        for i in range(1,n):
            dist+=houses[i]-houses[mail]
            dp[i][0]=dist
            if i%2!=0:
                mail+=1
        
        for j in range(1,k):
            for i in range(j+1,n):
                dp[i][j]=9999
                dist=0
                mail=i
                for m in range(i,j-1,-1):
                    dist+=houses[mail]-houses[m]
                    dp[i][j]=min(dp[i][j],dist+dp[m-1][j-1])
                    if (i-m+1)%2==0:
                        mail-=1
        
        return dp[n-1][k-1]