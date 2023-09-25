import heapq

class Position:
    def __init__(self,x,y,h):
        self.x=x
        self.y=y
        self.h=h
    
    def __lt__(self,other):
        return self.h<other.h

class Solution:
    def trapRainWater(self, heightMap: List[List[int]]) -> int:
        pq=[]
        n=len(heightMap)
        m=len(heightMap[0])
        heapq.heapify(pq)
        
        visited=[[False for j in range(m)] for i in range(n)]
        
        for j in range(1,m-1):
            visited[0][j]=True
            visited[n-1][j]=True
            heapq.heappush(pq,Position(0,j,heightMap[0][j]))
            heapq.heappush(pq,Position(n-1,j,heightMap[n-1][j]))
        
        for i in range(1,n-1):
            visited[i][0]=True
            visited[i][m-1]=True
            heapq.heappush(pq,Position(i,0,heightMap[i][0]))
            heapq.heappush(pq,Position(i,m-1,heightMap[i][m-1]))
        
        visited[0][0]=True
        visited[0][m-1]=True
        visited[n-1][0]=True
        visited[n-1][m-1]=True
        
        ans=0
        dirs=[[1,0],[-1,0],[0,1],[0,-1]]
        
        while pq:
            pos=heapq.heappop(pq)
            for dir1 in dirs:
                x=pos.x+dir1[0]
                y=pos.y+dir1[1]
                if x>=0 and x<n and y>=0 and y<m and not visited[x][y]:
                    visited[x][y]=True
                    if heightMap[x][y]<pos.h:
                        ans+=(pos.h-heightMap[x][y])
                        heightMap[x][y]=pos.h
                    heapq.heappush(pq,Position(x,y,heightMap[x][y]))
        
        return ans