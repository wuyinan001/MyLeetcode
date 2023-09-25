class UF:
    def __init__(self,n):
        self.V=n
        self.pi=[-1 for i in range(n)]
        self.rank=[0 for i in range(n)]
        self.cmp=0
    
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
    
    def numIslands2(self, m: int, n: int, positions: List[List[int]]) -> List[int]:
        dirs=[[1,0],[-1,0],[0,1],[0,-1]]
        uf=UF(m*n)
        ans=[]
        
        for pos in positions:
            N=pos[0]*n+pos[1]
            if uf.pi[N]==-1:
                uf.pi[N]=N
                uf.cmp+=1
            
            for dir1 in dirs:
                x=pos[0]+dir1[0]
                y=pos[1]+dir1[1]
                if x>=0 and x<m and y>=0 and y<n and uf.pi[x*n+y]!=-1:
                    uf.connect(N,x*n+y)
            
            ans.append(uf.cmp)
        
        return ans