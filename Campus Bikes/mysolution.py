import heapq

class Solution:
    
    def __init__(self):
        self.visited=None
        self.pq=[]
        self.n=0
        self.m=0
    
    class Position:
        def __init__(self,w,b,d):
            self.w=w
            self.b=b
            self.d=d
        
        def __lt__(self,other):
            if self.d==other.d:
                if self.w==other.w:
                    return self.b<other.b
                else:
                    return self.w<other.w
            else:
                return self.d<other.d
            
    def help(self,workers,w,bikes):
        m_id=-1
        min_dist=inf
        
        for i in range(self.m):
            if not self.visited[i]:
                dist=abs(workers[w][0]-bikes[i][0])+abs(workers[w][1]-bikes[i][1])
                if dist<min_dist:
                    m_id=i
                    min_dist=dist
        
        heapq.heappush(self.pq,self.Position(w,m_id,min_dist))
        
    
    def assignBikes(self, workers: List[List[int]], bikes: List[List[int]]) -> List[int]:
        self.n=len(workers)
        self.m=len(bikes)
        self.visited=[False for i in range(self.m)]
        heapq.heapify(self.pq)
        
        ans=[-1 for i in range(self.n)]
        count=0
        
        for w in range(self.n):
            self.help(workers,w,bikes)
        
        while self.pq:
            if count==self.n:
                break
            pos=heapq.heappop(self.pq)
            
            if not self.visited[pos.b]:
                self.visited[pos.b]=True
                ans[pos.w]=pos.b
                count+=1
            else:
                self.help(workers,pos.w,bikes)
                
        return ans