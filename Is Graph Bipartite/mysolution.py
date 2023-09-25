class Solution:
    def __init__(self):
        self.color={}
        self.isBipar=True
    
    def dfs(self,u,graph):
        for v in graph[u]:
            if v not in self.color:
                self.color[v]=not self.color[u]
                self.dfs(v,graph)
            elif self.color[v]==self.color[u]:
                self.isBipar=False
        
    def isBipartite(self, graph: List[List[int]]) -> bool:
        n=len(graph)
        
        for i in range(n):
            if not self.isBipar:
                return False
            if i not in self.color:
                self.color[i]=True
                self.dfs(i,graph)
        
        return True