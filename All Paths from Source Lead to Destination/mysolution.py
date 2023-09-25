class Solution:
    def __init__(self):
        self.V=0
        self.adj={}
        self.visited=None
        self.postOrder=None
        self.clock=0
    
    def dfs(self,source):
        self.visited[source]=True
        self.clock+=1
        for v in self.adj[source]:
            if not self.visited[v]:
                self.dfs(v)
        
        self.clock+=1
        self.postOrder[source]=self.clock
        
    def leadsToDestination(self, n: int, edges: List[List[int]], source: int, destination: int) -> bool:
        self.V=n
        for i in range(n):
            self.adj[i]=[]
        self.visited=[False for i in range(n)]
        self.postOrder=[-1 for i in range(n)]
        
        for edge in edges:
            self.adj[edge[0]].append(edge[1])
        
        self.dfs(source)
        
        for v in self.adj.keys():
            if self.postOrder[v]!=-1:
                if not self.adj[v] and v!=destination:
                    return False
                for w in self.adj[v]:
                    if self.postOrder[v]<=self.postOrder[w]:
                        return False
        
        return True