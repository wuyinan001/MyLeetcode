import heapq

class UF:
    def __init__(self,n):
        self.V=n
        self.cmp=n
        self.pi=[i for i in range(n)]
        self.rank=[0 for i in range(n)]
    
    def find(self,x):
        rx=x
        while rx!=self.pi[rx]:
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

class Pair:
    def __init__(self,x,y,val):
        self.x=x
        self.y=y
        self.val=val

    def __lt__(self,other):
        return self.val<other.val

class Solution:
    def minimumCost(self, n: int, connections: List[List[int]]) -> int:
        pq=[]
        heapq.heapify(pq)
        for c in connections:
            heapq.heappush(pq,Pair(c[0],c[1],c[2]))

        uf=UF(n)
        ans=0

        while pq:
            if uf.cmp==1:
                return ans
            curr=heapq.heappop(pq)
            if not uf.isConnected(curr.x-1,curr.y-1):
                ans+=curr.val
                uf.connect(curr.x-1,curr.y-1)
        
        return ans if uf.cmp==1 else -1