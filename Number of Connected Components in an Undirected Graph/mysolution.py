class Graph:
    def __init__(self,n,edges):
        self.V=n
        self.adj=[[] for i in range(n)]
        self.visited=[False for i in range(n)]
        
        for edge in edges:
            self.adj[edge[0]].append(edge[1])
            self.adj[edge[1]].append(edge[0])
        
        self.cmp=0
    
    def dfs(self,u):
        self.visited[u]=True
        
        for v in self.adj[u]:
            if not self.visited[v]:
                self.dfs(v)
    
    def dfs2(self):
        for i in range(self.V):
            if not self.visited[i]:
                self.cmp+=1
                self.dfs(i)
    
class Solution:
    def countComponents(self, n: int, edges: List[List[int]]) -> int:
        graph=Graph(n,edges)
        graph.dfs2()
        
        return graph.cmp