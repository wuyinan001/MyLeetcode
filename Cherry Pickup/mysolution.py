class Solution:
    
    def __init__(self):
        self.n=0
       
    
    def dp(self,grid,row1,col1,row2,memo):
        col2=row1+col1-row2
        if row1==self.n or col1==self.n or row2==self.n or col2==self.n or grid[row1][col1]==-1 or grid[row2][col2]==-1:
            return -inf
        
        if row1==self.n-1 and col1==self.n-1:
            return grid[row1][col1]
        
        if memo[row1][col1][row2]:
            return memo[row1][col1][row2]
        
        ans=grid[row1][col1]
        
        if row2!=row1 or col2!=col1:
            ans+=grid[row2][col2]
        
        ans+=max(self.dp(grid,row1+1,col1,row2+1,memo),self.dp(grid,row1+1,col1,row2,memo),
                 self.dp(grid,row1,col1+1,row2+1,memo),self.dp(grid,row1,col1+1,row2,memo))
        
        memo[row1][col1][row2]=ans
        return ans
        
    
    def cherryPickup(self, grid: List[List[int]]) -> int:
        self.n=len(grid)
        memo=[[[None for k in range(self.n)] for j in range(self.n)] for i in range(self.n)]
        ans=self.dp(grid,0,0,0,memo)
        
        return ans if ans!=-inf else 0