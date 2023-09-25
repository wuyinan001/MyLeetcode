import heapq

class Position:
    def __init__(self,x,y,d):
        self.x=x
        self.y=y
        self.d=d
    
    def __lt__(self,other):
        return self.d<other.d
    
class Solution:
    def shortestDistance(self, maze: List[List[int]], start: List[int], destination: List[int]) -> int:
        n=len(maze)
        m=len(maze[0])
        pq=[]
        heapq.heapify(pq)
        dirs=[[1,0],[-1,0],[0,1],[0,-1]]
        dist=[[inf for j in range(m)] for i in range(n)]
        
        heapq.heappush(pq,Position(start[0],start[1],0))
        dist[start[0]][start[1]]=0
        
        while pq:
            pos=heapq.heappop(pq)
            if pos.x==destination[0] and pos.y==destination[1]:
                return pos.d
            
            for dir1 in dirs:
                x=pos.x
                y=pos.y
                step=0
                
                while x>=0 and x<n and y>=0 and y<m and maze[x][y]!=1:
                    x+=dir1[0]
                    y+=dir1[1]
                    step+=1
                
                x-=dir1[0]
                y-=dir1[1]
                step-=1
                
                if dist[x][y]>pos.d+step:
                    dist[x][y]=pos.d+step
                    heapq.heappush(pq,Position(x,y,pos.d+step))
        
        return -1