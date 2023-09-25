import heapq

class UF:
    def __init__(self,n):
        self.V=n
        self.pi=[i for i in range(n)]
        self.rank=[0 for i in range(n)]
        self.cmp=n
    
    def find(self,x):
        rx=x
        while self.pi[rx]!=rx:
            rx=self.pi[rx]
        self.pi[x]=rx
        return rx
    
    def isConnected(self,x,y):
        return self.find(x)==self.find(y)
    
    def connect(self,x,y):
        if self.isConnected(x,y):
            return
        
        rx=self.find(x)
        ry=self.find(y)
        
        if self.rank[rx]>self.rank[ry]:
            self.pi[ry]=rx
        else:
            self.pi[rx]=ry
            if self.rank[rx]==self.rank[ry]:
                self.rank[ry]+=1
        
        self.cmp-=1

class Solution:
    def minCostToSupplyWater(self, n: int, wells: List[int], pipes: List[List[int]]) -> int:
        uf=UF(n+1)
        pq=[]
        heapq.heapify(pq)
        
        class MyObjs:
            def __init__(self,edge):
                self.edge=edge
                
            def __lt__(self,other):
                return self.edge[2]<other.edge[2]
            
        for pipe in pipes:
            heapq.heappush(pq,MyObjs(pipe))
            
        for i in range(len(wells)):
            heapq.heappush(pq,MyObjs([0,i+1,wells[i]]))
        
        ans=0
        
        while pq:
            edge=heapq.heappop(pq).edge
            if not uf.isConnected(edge[0],edge[1]):
                ans+=edge[2]
                uf.connect(edge[0],edge[1])
            
            if uf.cmp==1:
                break
        
        return ans