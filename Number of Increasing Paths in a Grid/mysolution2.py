class Solution:
    def __init__(self):
        self.n=0
        self.m=0
        self.dirs=[[1,0],[-1,0],[0,1],[0,-1]]
        self.mod=int(1e9+7)
    
    # dp(grid,row,col,memo) returns total number of increasing paths staring at (row,col)
    def dp(self,grid,row,col,memo):
        if memo[row][col]!=None:
            return memo[row][col]
        
        ans=1
        
        for dir1 in self.dirs:
            x=row+dir1[0]
            y=col+dir1[1]
            if x>=0 and x<self.n and y>=0 and y<self.m and grid[row][col]<grid[x][y]:
                ans=(ans+self.dp(grid,x,y,memo))%self.mod
        
        memo[row][col]=ans
        return ans
        
        
    def countPaths(self, grid: List[List[int]]) -> int:
        self.n=len(grid)
        self.m=len(grid[0])
        
        ans=0
        
        memo=[[None for _ in range(self.m)] for _ in range(self.n)]
        
        for i in range(self.n):
            for j in range(self.m):
                ans=(ans+self.dp(grid,i,j,memo))%self.mod
        
        return ans