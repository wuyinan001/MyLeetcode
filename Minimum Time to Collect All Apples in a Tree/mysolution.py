class Solution:
    def __init__(self):
        self.V=0
        self.adj=None
        self.visited=None
        self.list=None
    
    def dfs(self,u):
        self.visited[u]=True
        count=0
        
        for v in self.adj[u]:
            if not self.visited[v]:
                count+=self.dfs(v)
        
        if u!=0 and (self.list[u] or count>0):
            count+=2
        
        return count
    
    def minTime(self, n: int, edges: List[List[int]], hasApple: List[bool]) -> int:
        self.V=n
        self.adj=[[] for i in range(n)]
        
        for edge in edges:
            self.adj[edge[0]].append(edge[1])
            self.adj[edge[1]].append(edge[0])
        
        self.visited=[False for i in range(n)]
        self.list=hasApple
        
        return self.dfs(0)