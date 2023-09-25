import heapq

class Solution:
    def maximumMinimumPath(self, grid: List[List[int]]) -> int:
        n=len(grid)
        m=len(grid[0])
        
        L=[[-1 for j in range(m)] for i in range(n)]
        L[0][0]=grid[0][0]

        dirs=[[1,0],[-1,0],[0,1],[0,-1]]
        
        class MyObjs:
            def __init__(self,x,y):
                self.x=x
                self.y=y
                
            def __lt__(self,other):
                return L[self.x][self.y]>L[other.x][other.y]
        
        pq=[]
        heapq.heapify(pq)
        
        pq.append(MyObjs(0,0))
        
        while pq:
            loc=heapq.heappop(pq)
            
            if loc.x==n-1 and loc.y==m-1:
                return L[loc.x][loc.y]
            
            for dir1 in dirs:
                x=loc.x+dir1[0]
                y=loc.y+dir1[1]
                if x>=0 and x<n and y>=0 and y<m and L[x][y]<min(L[loc.x][loc.y],grid[x][y]):
                    L[x][y]=min(L[loc.x][loc.y],grid[x][y])
                    heapq.heappush(pq,MyObjs(x,y))
        
        return -1