class Solution:
    def __init__(self):
        self.n=0
        self.m=0
        self.start=()
        self.end=()
        self.visited=None
        self.dirs=[[1,0],[-1,0],[0,1],[0,-1]]
        self.ans=0
        
    def backTrack(self,grid,count,row,col):
        if (row,col)==self.end:
            if count==1:
                self.ans+=1
            return
        
        self.visited[row][col]=True
        
        for dir1 in self.dirs:
            x=row+dir1[0]
            y=col+dir1[1]
            if x>=0 and x<self.n and y>=0 and y<self.m and not self.visited[x][y] and grid[x][y]!=-1:
                self.backTrack(grid,count-1,x,y)
        
        self.visited[row][col]=False
        
    def uniquePathsIII(self, grid: List[List[int]]) -> int:
        self.n=len(grid)
        self.m=len(grid[0])
        obstacle=0
        
        for i in range(self.n):
            for j in range(self.m):
                if grid[i][j]==1:
                    self.start=(i,j)
                if grid[i][j]==2:
                    self.end=(i,j)
                if grid[i][j]==-1:
                    obstacle+=1
        
        self.visited=[[False for j in range(self.m)] for i in range(self.n)]
        self.backTrack(grid,self.n*self.m-obstacle,self.start[0],self.start[1])
        
        return self.ans