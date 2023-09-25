class Solution:
    def minSpaceWastedKResizing(self, nums: List[int], k: int) -> int:
        n=len(nums)
        dp=[[inf for j in range(k+1)] for i in range(n)]
        
        sum1=0
        max1=0
        
        for i in range(n):
            max1=max(max1,nums[i])
            sum1+=nums[i]
            dp[i][0]=max1*(i+1)-sum1

        for j in range(1,k+1):
            for i in range(1,n):
                sum1=0
                max1=0
                for l in range(i-1,-1,-1):
                    sum1+=nums[l+1]
                    max1=max(max1,nums[l+1])
                    dp[i][j]=min(dp[l][j-1]+(max1*(i-l))-sum1,dp[i][j])
        
        #print(dp)
        
        return dp[n-1][k]