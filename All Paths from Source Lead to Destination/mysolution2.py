class Graph:
    def __init__(self,n,edges):
        self.V=n
        self.visited=[False for i in range(n)]
        self.adj=[[] for i in range(n)]
        
        for edge in edges:
            self.adj[edge[0]].append(edge[1])
        
        self.postOrder=[-1 for i in range(n)]
        self.clock=0
    
    def dfs(self,u):
        self.visited[u]=True
        self.clock+=1
        for v in self.adj[u]:
            if not self.visited[v]:
                self.dfs(v)
        
        self.clock+=1
        self.postOrder[u]=self.clock
    
    def hasCycle(self):
        for u in range(self.V):
            if self.postOrder[u]!=-1:
                for v in self.adj[u]:
                    if self.postOrder[v]>=self.postOrder[u]:
                        return True
        return False
        
    
class Solution:
    def leadsToDestination(self, n: int, edges: List[List[int]], source: int, destination: int) -> bool:
        g=Graph(n,edges)
        g.dfs(source)
        if g.hasCycle():
            return False
        
        for v in range(n):
            if g.adj[v]==[] and g.visited[v] and v!=destination:
                return False
        
        return g.visited[destination]