class Solution:
    def findTheLongestBalancedSubstring(self, s: str) -> int:
        n=len(s)
        
        if n<=1:
            return 0
        elif n==2:
            return 2 if s=="01" else 0
        
        P=[[False for _ in range(n)] for _ in range(n)]
        
        maxLen=0
        
        for i in range(n):
            P[i][i]=True
            
        for i in range(n-1):
            if s[i:i+2]=="01":
                P[i][i+1]=True
                if maxLen<2:
                    maxLen=2
        
        for gap in range(3,n,2):
            for i in range(n-gap):
                j=i+gap
                if P[i+1][j-1] and s[i]=='0' and s[j]=='1':
                    P[i][j]=True
                    if maxLen<gap+1:
                        maxLen=1+gap
        
        return maxLen