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
    def removeStones(self, stones: List[List[int]]) -> int:
        n=len(stones)
        uf=UF(n)
        
        for i in range(n-1):
            for j in range(i+1,n):
                if stones[i][0]==stones[j][0] or stones[i][1]==stones[j][1]:
                    uf.connect(i,j)
        
        return n-uf.cmp