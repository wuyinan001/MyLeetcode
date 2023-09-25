class Graph:
    def __init__(self,n,edges):
        self.V=n
        self.adj={}
        
        for i in range(n):
            self.adj[i]=[]
            
        for edge in edges:
            self.adj[edge[0]].append(edge[1])
            self.adj[edge[1]].append(edge[0])
            
        self.visited=[False for i in range(n)]
        # sum of distance from all its children
        self.dist=[0 for i in range(n)]
        # num of children nodes
        self.children=[0 for i in range(n)]
        # sum of distance from all other nodes
        self.dist2=[0 for i in range(n)]
    
    def dfs1(self,u):
        self.visited[u]=True
        for v in self.adj[u]:
            if not self.visited[v]:
                self.dfs1(v)
                self.children[u]+=self.children[v]+1
                self.dist[u]+=self.dist[v]+self.children[v]+1
    
    def dfs2(self,u):
        self.visited[u]=True
        for v in self.adj[u]:
            if not self.visited[v]:
                self.dist2[v]=self.dist2[u]+(self.V-2-2*self.children[v])
                self.dfs2(v)
    
class Solution:
    def sumOfDistancesInTree(self, n: int, edges: List[List[int]]) -> List[int]:
        graph=Graph(n,edges)
        graph.dfs1(0)
        graph.dist2[0]=graph.dist[0]
        graph.visited=[False for i in range(n)]
        graph.dfs2(0)
        
        #print(graph.children)
        #print(graph.dist)
        
        return graph.dist2