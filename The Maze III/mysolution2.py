import heapq

class Position:
    def __init__(self,x,y,d,p):
        self.x=x
        self.y=y
        self.d=d
        self.p=p
    
    def __lt__(self,other):
        if self.d==other.d:
            return self.p<other.p
        return self.d<other.d
    
class Solution:
    def findShortestWay(self, maze: List[List[int]], ball: List[int], hole: List[int]) -> str:
        pq=[]
        heapq.heapify(pq)
        dirs=[[-1,0],[1,0],[0,-1],[0,1]]
        map1={0:"u",1:"d",2:"l",3:"r"}
        visited=set([])
        n=len(maze)
        m=len(maze[0])
        
        heapq.heappush(pq,Position(ball[0],ball[1],0,""))
        
        while pq:
            curr=heapq.heappop(pq)
            
            if curr.x==hole[0] and curr.y==hole[1]:
                return curr.p
            
            visited.add((curr.x,curr.y))
            
            for i in range(4):
                x=curr.x
                y=curr.y
                step=0
                while x>=0 and x<n and y>=0 and y<m and maze[x][y]!=1 and not (hole[0]==x and hole[1]==y):
                    x+=dirs[i][0]
                    y+=dirs[i][1]
                    step+=1
                
                if not (hole[0]==x and hole[1]==y):
                    x-=dirs[i][0]
                    y-=dirs[i][1]
                    step-=1
                
                if (x,y) not in visited:
                    heapq.heappush(pq,Position(x,y,curr.d+step,curr.p+map1[i]))
        
        return "impossible"