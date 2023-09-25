class Solution:
    def numDecodings(self, s: str) -> int:
        n=len(s)
        
        if n==1:
            if s=="0":
                return 0
            else:
                return 1
        elif n==2:
            if s[0]=="0":
                return 0
            ans=0
            if s[1]!='0':
                ans=1
            if int(s)>=1 and int(s)<=26:
                ans+=1
            return ans
        
        dp=[0 for i in range(n)]
        
        if s[0]!='0':
            dp[0]=1
            if s[1]!='0':
                dp[1]=1
            if int(s[0:2])>=1 and int(s[0:2])<=26:
                dp[1]+=1
        
        for i in range(2,n):
            if s[i]!='0':
                dp[i]=dp[i-1]
            if s[i-1]!='0' and int(s[i-1:i+1])>=1 and int(s[i-1:i+1])<=26:
                dp[i]+=dp[i-2]
        
        print(dp)
        return dp[n-1]