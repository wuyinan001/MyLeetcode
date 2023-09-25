class Solution:
    def islandPerimeter(self, grid: List[List[int]]) -> int:
        n=len(grid)
        m=len(grid[0])
        dirs=[[1,0],[-1,0],[0,1],[0,-1]]
        
        ans=0
        
        for i in range(n):
            for j in range(m):
                if grid[i][j]==1:
                    for dir1 in dirs:
                        x=i+dir1[0]
                        y=j+dir1[1]
                        if x>=0 and x<n and y>=0 and y<m and grid[x][y]==1:
                            continue
                        else:
                            ans+=1
        
        return ans