class Solution:
    def __init__(self):
        self.V=0
        self.adj=None
        self.visited=None
        self.clock=0
        self.postOrder=None
    
    def dfs(self,u):
        self.visited[u]=True
        self.clock+=1
        
        for v in self.adj[u]:
            if not self.visited[v]:
                self.dfs(v)
        
        self.clock+=1
        self.postOrder[u]=self.clock
        
    def dfs2(self):
        for i in range(self.V):
            if not self.visited[i]:
                self.dfs(i)
    
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        n=numCourses
        self.V=n
        self.adj=[]
        
        for i in range(n):
            self.adj.append([])
        
        for edge in prerequisites:
            self.adj[edge[1]].append(edge[0])
        
        self.visited=[False for i in range(n)]
        self.postOrder=[-1 for i in range(n)]
        
        self.dfs2()
        
        for edge in prerequisites:
            if self.postOrder[edge[1]]<=self.postOrder[edge[0]]:
                return False
        
        return True