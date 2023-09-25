class Solution:
    def shortestDistance(self, grid: List[List[int]]) -> int:
        n=len(grid)
        m=len(grid[0])
        
        houses=0
        set1=set([])
        dict1={}
        queue=[]
        dirs=[[1,0],[-1,0],[0,1],[0,-1]]
        dist=0
        
        for i in range(n):
            for j in range(m):
                if grid[i][j]==1:
                    houses+=1
                    set1.clear()
                    queue.append((i,j))
                    set1.add((i,j))
                    dist=0
                    
                    while queue:
                        size=len(queue)
                        for k in range(size):
                            pos=queue.pop(0)
                            if grid[pos[0]][pos[1]]==0:
                                if pos not in dict1:
                                    dict1[pos]=[]
                                dict1[pos].append(dist)
                            for dir1 in dirs:
                                x=pos[0]+dir1[0]
                                y=pos[1]+dir1[1]
                                if x>=0 and x<n and y>=0 and y<m and grid[x][y]==0 and (x,y) not in set1:
                                    queue.append((x,y))
                                    set1.add((x,y))
                        dist+=1
        
        ans=inf
        for key in dict1:
            if len(dict1[key])==houses:
                ans=min(ans,sum(dict1[key]))
        
        return ans if ans!=inf else -1