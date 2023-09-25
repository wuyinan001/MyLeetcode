class Solution:
    
    def __init__(self):
        self.n=0
        self.m=0
    
    def dp(self,s,p,i,j,memo):
        if i==self.n:
            if j==self.m:
                return True
            elif p[j]=="*":
                return self.dp(s,p,i,j+1,memo)
            else:
                return False
        
        if j==self.m:
            return False
        
        if memo[i][j]!=None:
            return memo[i][j]
        
        ans=False
        firstMatch=s[i]==p[j] or p[j]=="?"
        
        if p[j]=="*":
            ans=self.dp(s,p,i+1,j,memo) or self.dp(s,p,i,j+1,memo)
        else:
            ans=firstMatch and self.dp(s,p,i+1,j+1,memo)
        
        memo[i][j]=ans
        return ans
        
    def isMatch(self, s: str, p: str) -> bool:
        self.n=len(s)
        self.m=len(p)
        memo=[[None for j in range(self.m)] for i in range(self.n)]
        
        return self.dp(s,p,0,0,memo)