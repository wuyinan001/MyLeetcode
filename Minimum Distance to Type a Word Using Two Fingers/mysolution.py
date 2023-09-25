class Solution:
    def __init__(self):
        self.dist=[[0 for j in range(27)] for i in range(27)]
        
        for i in range(26):
            for j in range(26):
                x1=(int)(i/6)
                y1=i%6
                x2=(int)(j/6)
                y2=j%6
                self.dist[i][j]=abs(x1-x2)+abs(y1-y2)
                
    def dp(self,word,i,j,k,memo):
        if k==0:
            c=ord(word[k])-ord('A')
            if i==c or j==c:
                return 0
            else:
                return inf
        
        if memo[i][j][k]!=None:
            return memo[i][j][k]
        
        c=ord(word[k])-ord('A')
        ans=inf
        
        if i==c:
            for ii in range(27):
                ans=min(ans,self.dp(word,ii,j,k-1,memo)+self.dist[i][ii])
        
        if j==c:
            for jj in range(27):
                ans=min(ans,self.dp(word,i,jj,k-1,memo)+self.dist[j][jj])
                
        memo[i][j][k]=ans
        return ans
    
    def minimumDistance(self, word: str) -> int:
        length=len(word)
        memo=[[[None for k in range(length)] for j in range(27)] for i in range(27)]
        
        ans=inf
        
        for i in range(27):
            for j in range(27):
                ans=min(ans,self.dp(word,i,j,length-1,memo))
        
        return ans