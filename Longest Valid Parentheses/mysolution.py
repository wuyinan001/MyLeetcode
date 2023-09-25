class Solution:
    def longestValidParentheses(self, s: str) -> int:
        n=len(s)
        if n==0 or n==1:
            return 0
        elif n==2:
            if s[0]=="(" and s[1]==")":
                return 2
            else:
                return 0
        
        dp=[0 for i in range(n)]
        
        if s[0]=="(" and s[1]==")":
            dp[1]=2
        
        for i in range(2,n):
            if s[i]==")":
                j=i-1-dp[i-1]
                if j>=0 and s[j]=="(":
                    dp[i]=2+dp[i-1]
                    if j>0:
                        dp[i]+=dp[j-1]
        
        ans=0
        
        for i in range(1,n):
            ans=max(ans,dp[i])
            
        return ans