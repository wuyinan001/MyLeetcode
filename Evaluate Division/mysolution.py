class UF:
    def __init__(self,n):
        self.V=n
        self.pi=[i for i in range(n)]
        self.ratio=[1.0 for i in range(n)]
        self.rank=[0 for i in range(n)]
        
    def find(self,x):
        rx=x
        while rx!=self.pi[rx]:
            rx=self.pi[rx]
        
        self.pi[x]=rx
        return rx
    
    def isConnected(self,x,y):
        return self.find(x)==self.find(y)
    
    def connect(self,x,y,r):
        if self.isConnected(x,y):
            return
        
        rx=self.find(x)
        ry=self.find(y)
        ratio_rx_ry=r*self.ratio[y]/self.ratio[x]
        
        if self.rank[rx]>self.rank[ry]:
            for i in range(self.V):
                if self.find(i)==ry:
                    self.ratio[i]=self.ratio[i]/ratio_rx_ry
            self.pi[ry]=rx
        else:
            for i in range(self.V):
                if self.find(i)==rx:
                    self.ratio[i]=self.ratio[i]*ratio_rx_ry
            self.pi[rx]=ry
            if self.rank[rx]==self.rank[ry]:
                self.rank[ry]+=1

class Solution:
    def calcEquation(self, equations: List[List[str]], values: List[float], queries: List[List[str]]) -> List[float]:
        dict1={}
        n=0
        for eq in equations:
            if eq[0] not in dict1:
                dict1[eq[0]]=n
                n+=1
            if eq[1] not in dict1:
                dict1[eq[1]]=n
                n+=1
        
        uf=UF(n)
        
        m1=len(values)
        for i in range(m1):
            uf.connect(dict1[equations[i][0]],dict1[equations[i][1]],values[i])
        
        ans=[]
        for q in queries:
            if q[0] in dict1 and q[1] in dict1 and uf.isConnected(dict1[q[0]],dict1[q[1]]):
                ans.append(uf.ratio[dict1[q[0]]]/uf.ratio[dict1[q[1]]])
            else:
                ans.append(-1.0)
        
        return ans