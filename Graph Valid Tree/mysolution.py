class Solution:
    
    def __init__(self):
        self.V=0
        self.adj=None
        self.visited=None
        self.cmp=0
        
    def dfs(self,u):
        self.visited[u]=True
        
        for v in self.adj[u]:
            if not self.visited[v]:
                self.dfs(v)
    
    def validTree(self, n: int, edges: List[List[int]]) -> bool:
        m=len(edges)
        
        if m!=n-1:
            return False
        
        self.V=n
        self.adj=[[] for i in range(n)]
        
        for edge in edges:
            self.adj[edge[0]].append(edge[1])
            self.adj[edge[1]].append(edge[0])
        
        self.visited=[False for i in range(n)]
        
        for i in range(n):
            if not self.visited[i]:
                self.cmp+=1
                self.dfs(i)
        
        return self.cmp==1