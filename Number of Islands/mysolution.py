class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        
        dirs=[(1,0),(-1,0),(0,1),(0,-1)]
        
        n=len(grid)
        m=len(grid[0])
        
        ans=0
        queue=[]
        
        for i in range(n):
            for j in range(m):
                if grid[i][j]=='1':
                    ans+=1
                    grid[i][j]='0'
                    queue.append((i,j))
                    while queue:
                        x,y=queue.pop(0)
                        for d in dirs:
                            xx=x+d[0]
                            yy=y+d[1]
                            if xx>=0 and xx<n and yy>=0 and yy<m and grid[xx][yy]=='1':
                                queue.append((xx,yy))
                                grid[xx][yy]='0'
        
        return ans