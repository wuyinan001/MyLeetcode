class Solution:
    def match(self,s,t):
        n=len(s)
        dp=[[0 for j in range(4)] for i in range(n+1)]
        
        for i in range(n+1):
            dp[i][0]=1
        
        for i in range(1,n+1):
            for j in range(1,4):
                if s[i-1]==t[j-1]:
                    dp[i][j]=dp[i-1][j-1]+dp[i-1][j]
                else:
                    dp[i][j]=dp[i-1][j]
        
        return dp[n][3]
    
    def numberOfWays(self, s: str) -> int:        
        return self.match(s,"010")+self.match(s,"101")