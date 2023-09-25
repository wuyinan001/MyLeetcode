class Solution:
    def minTotalDistance(self, grid: List[List[int]]) -> int:
        map1={}
        
        n=len(grid)
        m=len(grid[0])
        
        dirs=[[1,0],[-1,0],[0,1],[0,-1]]
        
        for i in range(n):
            for j in range(m):
                map1[(i,j)]=[]
        
        visited=set([])
        queue=[]
        
        for i in range(n):
            for j in range(m):
                if grid[i][j]==1:
                    queue.append((i,j))
                    step=0
                    visited.clear()
                    visited.add((i,j))
                    while queue:
                        size=len(queue)
                        for _ in range(size):
                            x,y=queue.pop(0)
                            map1[(x,y)].append(step)
                            for dir1 in dirs:
                                xx=x+dir1[0]
                                yy=y+dir1[1]
                                if xx>=0 and xx<n and yy>=0 and yy<m and (xx,yy) not in visited:
                                    queue.append((xx,yy))
                                    visited.add((xx,yy))
                        step+=1
        
        ans=float('inf')
        
        for key in map1:
            ans=min(ans,sum(map1[key]))
        
        return ans