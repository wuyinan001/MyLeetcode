class Solution:
    def mergeStones(self, stones: List[int], k: int) -> int:
        n=len(stones)
        if (n-1)%(k-1)!=0:
            return -1
        
        # min cost to merge stones from i to j to (j-i)%(k-1)+1 piles
        dp=[[0 for j in range(n)] for i in range(n)]
        
        # presum[i]: sum from stones[0] to stones[i-1]
        # sum from stones[i] to stones[j]=presum[j+1]-presum[i]
        presum=[0 for i in range(n+1)]
        
        for i in range(1,n+1):
            presum[i]=stones[i-1]+presum[i-1]
        
        # when gap<k-1, there are not enough stones to merge. dp[i][i+gap]=0
        for gap in range(k-1,n,1):
            for i in range(n-gap):
                j=i+gap
                dp[i][j]=inf
                # dp[i][j] is the min of the following case:
                # put i to m into one pile(this can always be done because (m-i+1)%k=1 and 
                # put m+1 to j into rest piles
                for m in range(i,j,k-1):
                    dp[i][j]=min(dp[i][j],dp[i][m]+dp[m+1][j])
                
                if (j-i)%(k-1)==0:
                    dp[i][j]+=presum[j+1]-presum[i]
        
        return dp[0][n-1]