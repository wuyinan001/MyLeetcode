class UF:
    def __init__(self,n):
        self.pi=[i for i in range(n)]
        self.rank=[0 for i in range(n)]
        self.ratio=[1.0 for  i in range(n)]
        self.V=n
    
    def find(self,x):
        rx=x
        while self.pi[rx]!=rx:
            rx=self.pi[rx]
        self.pi[x]=rx
        return rx
    
    def isConnected(self,x,y):
        return self.find(x)==self.find(y)
    
    # x/y=r
    # R: ry/rx=(x/rx)/(y/ry)*(y/x)
    def connect(self,x,y,r):
        if self.isConnected(x,y):
            return
        
        rx=self.find(x)
        ry=self.find(y)
        R=self.ratio[x]/self.ratio[y]/r
        
        if self.rank[rx]>self.rank[ry]:
            for i in range(self.V):
                if self.find(i)==ry:
                    # y/rx=(y/ry)*(ry/rx)
                    self.ratio[i]=self.ratio[i]*R
            self.pi[ry]=rx
        else:
            for i in range(self.V):
                if self.find(i)==rx:
                    # x/ry=(x/rx)/(ry/rx)
                    self.ratio[i]=self.ratio[i]/R
            self.pi[rx]=ry
            if self.rank[rx]==self.rank[ry]:
                self.rank[ry]+=1
        

class Solution:
    def calcEquation(self, equations: List[List[str]], values: List[float], queries: List[List[str]]) -> List[float]:
        dict={}
        num=0
        for eq in equations:
            if eq[0] not in dict:
                dict[eq[0]]=num
                num+=1
            if eq[1] not in dict:
                dict[eq[1]]=num
                num+=1
        
        uf=UF(num)
        
        n=len(equations)
        m=len(queries)
        
        for i in range(n):
            uf.connect(dict[equations[i][0]],dict[equations[i][1]],values[i])
        
        ans=[]
        
        for i in range(m):
            if queries[i][0] in dict and queries[i][1] in dict and uf.isConnected(dict[queries[i][0]],dict[queries[i][1]]):
                ans.append(uf.ratio[dict[queries[i][0]]]/uf.ratio[dict[queries[i][1]]])
            else:
                ans.append(-1.0)
        
        return ans