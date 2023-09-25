class Solution:
    def __init__(self):
        self.n=0
        self.m=0
        self.dirs=[[1,0],[-1,0],[0,1],[0,-1]]
    
    def dp(self,matrix,i,j,memo):
        if memo[i][j]!=None:
            return memo[i][j]
        
        ans=0
        for dir1 in self.dirs:
            x=i+dir1[0]
            y=j+dir1[1]
            if x>=0 and x<self.n and y>=0 and y<self.m and matrix[x][y]>matrix[i][j]:
                ans=max(ans,self.dp(matrix,x,y,memo))
        
        ans+=1
        memo[i][j]=ans
        
        return ans
                
        
    def longestIncreasingPath(self, matrix: List[List[int]]) -> int:
        self.n=len(matrix)
        self.m=len(matrix[0])
        memo=[[None for j in range(self.m)] for i in range(self.n)]
        
        ans=0
        
        for i in range(self.n):
            for j in range(self.m):
                ans=max(ans,self.dp(matrix,i,j,memo))
        
        return ans