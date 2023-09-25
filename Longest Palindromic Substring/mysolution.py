class Solution:
    def longestPalindrome(self, s: str) -> str:
        n=len(s)
        if n<=1:
            return s
        if n==2:
            if s[0]==s[1]:
                return s
            else:
                return s[0]
        
        P=[[False for i in range(n)] for j in range(n)]
        
        ans=s[0]
        
        for i in range(n):
            P[i][i]=True
        
        for i in range(n-1):
            if s[i]==s[i+1]:
                P[i][i+1]=True
                if len(ans)<2:
                    ans=s[i:i+2]
        
        for gap in range(2,n):
            for i in range(n-gap):
                j=i+gap
                if s[i]==s[j] and P[i+1][j-1]:
                    P[i][j]=True
                    if len(ans)<gap+1:
                        ans=s[i:j+1]

        return ans