class Graph:
    def __init__(self,n,edges):
        self.V=n
        self.adj=[[] for i in range(n)]
        
        for edge in edges:
            self.adj[edge[0]].append(edge[1])
            self.adj[edge[1]].append(edge[0])
        
        self.visited=[False for i in range(n)]
    
    def dfs(self,u,hasApple):
        ans=0
        self.visited[u]=True
        
        for v in self.adj[u]:
            if not self.visited[v]:
                ans+=self.dfs(v,hasApple)
        
        if (ans>0 or hasApple[u]) and u!=0:
            ans+=2
        
        return ans
    
class Solution:
    def minTime(self, n: int, edges: List[List[int]], hasApple: List[bool]) -> int:
        graph=Graph(n,edges)
        return graph.dfs(0,hasApple)