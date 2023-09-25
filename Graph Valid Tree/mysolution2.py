class Graph:
    def __init__(self,n,edges):
        self.V=n
        self.E=0
        self.adj={}
        
        for i in range(n):
            self.adj[i]=[]
        
        for edge in edges:
            self.E+=1
            self.adj[edge[0]].append(edge[1])
            self.adj[edge[1]].append(edge[0])
        
        self.visited=[False for i in range(n)]
        self.cycle=False
    
    def dfs1(self,v,u):
        self.visited[v]=True
        for w in self.adj[v]:
            if not self.visited[w]:
                self.dfs1(w,v)
            elif w!=u:
                self.cycle=True
    
    def dfs2(self):
        for i in range(self.V):
            if not self.visited[i]:
                self.dfs1(i,-1)
    
class Solution:
    def validTree(self, n: int, edges: List[List[int]]) -> bool:
        graph=Graph(n,edges)
        graph.dfs2()
        return (n==1+graph.E) and not graph.cycle