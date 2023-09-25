class Solution:
    def countSubstrings(self, s: str) -> int:
        n=len(s)
        if n==1:
            return 1
        
        P=[[False for j in range(n)] for i in range(n)]
        
        for i in range(n):
            P[i][i]=True
        
        ans=n
        for i in range(n-1):
            if s[i]==s[i+1]:
                P[i][i+1]=True
                ans+=1
        
        for gap in range(2,n):
            for i in range(n-gap):
                j=i+gap
                if s[i]==s[j] and P[i+1][j-1]:
                    P[i][j]=True
                    ans+=1
        
        return ans