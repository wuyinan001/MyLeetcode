class UF:
    def __init__(self,n):
        self.V=n
        self.pi=[i for i in range(n)]
        self.rank=[0 for i in range(n)]
        self.ratio=[1.0 for i in range(n)]
        
    def find(self,x):
        rx=x
        while self.pi[rx]!=rx:
            rx=self.pi[rx]
        self.pi[x]=rx
        return rx
    
    def isConnected(self,x,y):
        return self.find(x)==self.find(y)
    
    def connect(self,x,y,r):
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
    def checkContradictions(self, equations: List[List[str]], values: List[float]) -> bool:
        n=len(equations)
        
        dict1={}
        count=0
        
        for eq in equations:
            if eq[0] not in dict1:
                dict1[eq[0]]=count
                count+=1
            if eq[1] not in dict1:
                dict1[eq[1]]=count
                count+=1
        
        uf=UF(count)
        
        for i in range(n):
            c1=equations[i][0]
            c2=equations[i][1]
            if not uf.isConnected(dict1[c1],dict1[c2]):
                uf.connect(dict1[c1],dict1[c2],values[i])
            else:
                #print(uf.ratio[dict1[c1]]/uf.ratio[dict1[c2]])
                if abs(values[i]-uf.ratio[dict1[c1]]/uf.ratio[dict1[c2]])>1e-5:
                    print(equations[i]," ",values[i])
                    return True
            
        return False