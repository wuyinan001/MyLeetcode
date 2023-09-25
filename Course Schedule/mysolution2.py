class Graph:
    def __init__(self,n,edges):
        self.V=n
        self.adj={}
        
        for i in range(n):
            self.adj[i]=[]
        
        for edge in edges:
            self.adj[edge[1]].append(edge[0])
        
        self.visited=[False for i in range(n)]
        self.postOrder=[-1 for i in range(n)]
        self.clock=0
    
    def dfs1(self,u):
        self.visited[u]=True
        self.clock+=1
        for v in self.adj[u]:
            if not self.visited[v]:
                self.dfs1(v)
        
        self.clock+=1
        self.postOrder[u]=self.clock
    
    def dfs2(self):
        for i in range(self.V):
            if not self.visited[i]:
                self.dfs1(i)
    
    def hasCycle(self):
        for key in self.adj:
            for v in self.adj[key]:
                if self.postOrder[key]<=self.postOrder[v]:
                    return True
        return False
        
            
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        g=Graph(numCourses,prerequisites)
        g.dfs2()
        return not g.hasCycle()