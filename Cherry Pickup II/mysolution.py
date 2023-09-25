class Solution:
    def __init__(self):
        self.n=0
        self.m=0
    
    def dp(self,grid,r1,c1,c2,memo):
        if c1<0 or c1>=self.m or c2<0 or c2>=self.m:
            return -inf
        
        if r1==self.n:
            return 0
        
        if memo[r1][c1][c2]!=None:
            return memo[r1][c1][c2]
        
        ans=grid[r1][c1]
        if c1!=c2:
            ans+=grid[r1][c2]
        
        max1=0
        for i in range(-1,2):
            for j in range(-1,2):
                max1=max(max1,self.dp(grid,r1+1,c1+i,c2+j,memo))
        
        ans+=max1
        memo[r1][c1][c2]=ans
        return ans
        
    
    def cherryPickup(self, grid: List[List[int]]) -> int:
        self.n=len(grid)
        self.m=len(grid[0])
        memo=[[[None for k in range(self.m)] for j in range(self.m)] for i in range(self.n)]
        
        return self.dp(grid,0,0,self.m-1,memo)