class Solution:
    
    def __init__(self):
        self.n=0
        self.m=0
        self.visited=None
        self.dirs=[[1,0],[-1,0],[0,1],[0,-1]]
    
    def backTrack(self,grid,row,col,sum1):
        if row<0 or row>=self.n or col<0 or col>=self.m or grid[row][col]==0 or self.visited[row][col]:
            return sum1
        
        self.visited[row][col]=True
        ans=0
        for dir1 in self.dirs:
            ans=max(ans,self.backTrack(grid,row+dir1[0],col+dir1[1],sum1+grid[row][col]))
        
        self.visited[row][col]=False
        return ans
        
    
    def getMaximumGold(self, grid: List[List[int]]) -> int:
        self.n=len(grid)
        self.m=len(grid[0])
        self.visited=[[False for j in range(self.m)] for i in range(self.n)]
        
        ans=0
        
        for i in range(self.n):
            for j in range(self.m):
                ans=max(ans,self.backTrack(grid,i,j,0))
        
        return ans