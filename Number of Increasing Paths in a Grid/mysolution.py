class Solution:
    def __init__(self):
        self.n=0
        self.m=0
        self.min=float('inf')
        self.dirs=[[1,0],[-1,0],[0,1],[0,-1]]
        self.MOD=int(1e9+7)
      
	# total number of increasing paths that end at (row,col)
	# memo used to cached the results computed before
    def dp(self,grid,row,col,memo):
        if memo[row][col]!=None:
            return memo[row][col]
        
        if grid[row][col]==self.min:
            memo[row][col]=1
            return 1
        
        ans=1
        
        for dir1 in self.dirs:
            x=row+dir1[0]
            y=col+dir1[1]
            if x>=0 and x<self.n and y>=0 and y<self.m and grid[row][col]>grid[x][y]:
                ans=(self.dp(grid,x,y,memo)+ans)%self.MOD
        
        memo[row][col]=ans
        return ans
        
    
    def countPaths(self, grid: List[List[int]]) -> int:
        self.n=len(grid)
        self.m=len(grid[0])
        
        for i in range(self.n):
            for j in range(self.m):
                self.min=min(self.min,grid[i][j])
        
        memo=[[None for _ in range(self.m)] for _ in range(self.n)]
        
        ans=0
        
        for i in range(self.n):
            for j in range(self.m):
                ans=(self.dp(grid,i,j,memo)+ans)%self.MOD
                
        return ans