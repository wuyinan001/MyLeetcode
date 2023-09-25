class Solution:
    
    def __init__(self):
        self.n=0
        self.m=0
        self.dirs=[[1,0],[-1,0],[0,1],[0,-1]]
        self.obs=0
        self.start=[]
        self.end=[]
        self.visited=None
        self.ans=0
        
    def backTrack(self,grid,row,col,count):
        
        #print("row",row,"col",col)
        
        if row==self.end[0] and col==self.end[1]:
            #print("count",count)
            if count==self.n*self.m-self.obs:
                self.ans+=1
            return
        
        self.visited[row][col]=True
        
        for dir1 in self.dirs:
            x=row+dir1[0]
            y=col+dir1[1]
            
            if x>=0 and x<self.n and y>=0 and y<self.m and not self.visited[x][y] and grid[x][y]!=-1:
                self.backTrack(grid,x,y,count+1)
        
        self.visited[row][col]=False
        
    
    def uniquePathsIII(self, grid: List[List[int]]) -> int:
        self.n=len(grid)
        self.m=len(grid[0])
        self.visited=[[False for i in range(self.m)] for j in range(self.n)]
        
        for i in range(self.n):
            for j in range(self.m):
                if grid[i][j]==1:
                    self.start.append(i)
                    self.start.append(j)
                if grid[i][j]==2:
                    self.end.append(i)
                    self.end.append(j)
                if grid[i][j]==-1:
                    self.obs+=1
        
        #print(self.obs)
        #print(self.start)
        #print(self.end)
        self.backTrack(grid,self.start[0],self.start[1],1);
        
        return self.ans