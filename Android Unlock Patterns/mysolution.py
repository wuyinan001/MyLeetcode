class Solution:
    def __init__(self):
        self.dirs=[[1,0],[-1,0],[0,1],[0,-1],[1,1],[-1,-1],[-1,1],[1,-1],
                  [2,1],[1,2],[-1,2],[-2,1],[-2,-1],[-1,-2],[1,-2],[2,-1]]
        self.crossdirs=[[2,0],[-2,0],[0,2],[0,-2],[2,2],[-2,-2],[-2,2],[2,-2]]
        self.visited=[[False for j in range(3)] for i in range(3)]
        self.ans=0
        self.n=0
        self.m=0
    
    def isValid(self,row,col):
        return row>=0 and row<3 and col>=0 and col<3 and not self.visited[row][col]
    
    def backTrack(self,row,col,count):
        if count>self.n:
            return
        
        if count>=self.m:
            self.ans+=1
        
        self.visited[row][col]=True
        
        for dir in self.dirs:
            x=row+dir[0]
            y=col+dir[1]
            if self.isValid(x,y):
                self.backTrack(x,y,count+1)
        
        for dir in self.crossdirs:
            x=row+dir[0]
            y=col+dir[1]
            x_mid=(row+x)//2
            y_mid=(col+y)//2
            if x_mid>=0 and x_mid<3 and y_mid>=0 and y_mid<3 and self.visited[x_mid][y_mid] and self.isValid(x,y):
                self.backTrack(x,y,count+1)
        
        self.visited[row][col]=False
        
    def numberOfPatterns(self, m: int, n: int) -> int:
        self.n=n
        self.m=m
        for i in range(3):
            for j in range(3):
                self.backTrack(i,j,1)
        
        return self.ans