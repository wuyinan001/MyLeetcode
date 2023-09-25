class Graph:
    def __init__(self,parents):
        self.V=len(parents)
        self.adj=[[] for i in range(self.V)]

        for i in range(1,len(parents)):
            self.adj[i].append(parents[i])
            self.adj[parents[i]].append(i)
        
        self.visited=[False for i in range(self.V)]
        self.max=0
        self.ans=0
    
    def dfs(self,u):
        self.visited[u]=True
        cmps=[]

        for v in self.adj[u]:
            if not self.visited[v]:
                cmps.append(self.dfs(v))
        
        product=1
        for i in cmps:
            product=product*i
        
        if u!=0:
            product=product*(self.V-sum(cmps)-1)
        
        if product>=self.max:
            if product>self.max:
                self.max=product
                self.ans=0
            self.ans+=1

        return 1+sum(cmps)

class Solution:
    def countHighestScoreNodes(self, parents: List[int]) -> int:
        graph=Graph(parents)
        graph.dfs(0)

        return graph.ans