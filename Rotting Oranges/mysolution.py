class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        n=len(grid)
        m=len(grid[0])
        
        queue=[]
        
        for i in range(n):
            for j in range(m):
                if grid[i][j]==2:
                    queue.append((i,j))
        
        ans=0
        
        dirs=[[1,0],[-1,0],[0,1],[0,-1]]
        
        while queue:
            size=len(queue)
            for _ in range(size):
                curr=queue.pop(0)
                for dir1 in dirs:
                    x=curr[0]+dir1[0]
                    y=curr[1]+dir1[1]
                    if x>=0 and x<n and y>=0 and y<m and grid[x][y]==1:
                        queue.append((x,y))
                        grid[x][y]=2
            
            if queue:
                ans+=1
        
        for i in range(n):
            for j in range(m):
                if grid[i][j]==1:
                    return -1
        
        return ans