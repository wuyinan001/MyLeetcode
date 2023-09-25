class Graph:
    def __init__(self,n,edges):
        self.V=n
        self.adj=[[] for i in range(n)]
        for edge in edges:
            self.adj[edge[0]].append(edge[1])
            self.adj[edge[1]].append(edge[0])
        
        self.visited=[False for i in range(n)]
        self.parent=[-1 for i in range(n)]
        self.arrival=[0 for i in range(n)]
        self.low=[0 for i in range(n)]
        self.clock=0
        self.ans=[]
    
    def dfs(self,u):
        self.visited[u]=True
        self.clock+=1
        self.arrival[u]=self.clock
        self.low[u]=self.clock
        
        for v in self.adj[u]:
            if not self.visited[v]:
                self.parent[v]=u
                self.dfs(v)
                self.low[u]=min(self.low[u],self.low[v])
                
                if self.low[v]>self.arrival[u]:
                    self.ans.append([u,v])
            elif v!=self.parent[u]:
                self.low[u]=min(self.low[u],self.arrival[v])
    
    def dfs2(self):
        for i in range(self.V):
            if not self.visited[i]:
                self.dfs(i)
        

class Solution:
    def criticalConnections(self, n: int, connections: List[List[int]]) -> List[List[int]]:
        graph=Graph(n,connections)
        graph.dfs2()
        return graph.ans