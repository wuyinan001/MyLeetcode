class Solution:
    def numDecodings(self, s: str) -> int:
        n=len(s)
        
        if n==1:
            if s=="0":
                return 0
            else:
                return 1
        
        L=[0 for i in range(n+1)]
        L[0]=1
        
        if s[0]!="0":
            L[1]=1
        
        for i in range(2,n+1):
            if s[i-2]!="0" and int(s[i-2:i])<=26:
                L[i]=L[i-2]
            
            if s[i-1]!="0":
                L[i]+=L[i-1]
        
        return L[n]