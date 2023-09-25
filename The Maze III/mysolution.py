import heapq

class Solution:
    def findShortestWay(self, maze: List[List[int]], ball: List[int], hole: List[int]) -> str:
        pq=[]
        heapq.heapify(pq)
        dirs=[[-1,0],[1,0],[0,-1],[0,1]]
        map1={0:"u",1:"d",2:"l",3:"r"}
        visited=set([])
        n=len(maze)
        m=len(maze[0])
        
        dist=[[float('inf') for j in range(m)] for i in range(n)]
        dist[ball[0]][ball[1]]=0
        path=[['z' for j in range(m)] for i in range(n)]
        path[ball[0]][ball[1]]=''
        
        class Position:
            def __init__(self,x,y):
                self.x=x
                self.y=y

            def __lt__(self,other):
                if dist[self.x][self.y]==dist[other.x][other.y]:
                    return path[self.x][self.y]<path[other.x][other.y]
                return dist[self.x][self.y]<dist[other.x][other.y]
        
        heapq.heappush(pq,Position(ball[0],ball[1]))
        
        while pq:
            curr=heapq.heappop(pq)
            
            if curr.x==hole[0] and curr.y==hole[1]:
                return path[curr.x][curr.y]
            
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
                
                if dist[curr.x][curr.y]+step<dist[x][y]:
                    dist[x][y]=dist[curr.x][curr.y]+step
                    path[x][y]=path[curr.x][curr.y]+map1[i]
                    heapq.heappush(pq,Position(x,y))
                elif dist[curr.x][curr.y]+step==dist[x][y] and path[curr.x][curr.y]+map1[i]<path[x][y]:
                    path[x][y]=path[curr.x][curr.y]+map1[i]
                    heapq.heappush(pq,Position(x,y))
        
        return "impossible"