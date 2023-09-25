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
        dirs=[[1,0],[-1,0],[0,1],[0,-1]]
        n=len(maze)
        m=len(maze[0])
        pq=[]
        heapq.heapify(pq)
        heapq.heappush(pq,Position(start[0],start[1],0))
        visited=set([])
        
        while pq:
            curr=heapq.heappop(pq)
            if curr.x==destination[0] and curr.y==destination[1]:
                return curr.d
            
            visited.add((curr.x,curr.y))
            
            for dir1 in dirs:
                x=curr.x
                y=curr.y
                step=0
                while x>=0 and x<n and y>=0 and y<m and maze[x][y]!=1:
                    x+=dir1[0]
                    y+=dir1[1]
                    step+=1
                
                x-=dir1[0]
                y-=dir1[1]
                step-=1
                
                if (x,y) not in visited:
                    heapq.heappush(pq,Position(x,y,curr.d+step))
        
        return -1