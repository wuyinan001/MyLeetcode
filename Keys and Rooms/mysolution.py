class Graph:
    def __init__(self,rooms):
        self.V=len(rooms)
        self.adj=rooms
        self.visited=[False for i in range(self.V)]
    
    def dfs(self,u):
        self.visited[u]=True
        for v in self.adj[u]:
            if not self.visited[v]:
                self.dfs(v)

class Solution:
    def canVisitAllRooms(self, rooms: List[List[int]]) -> bool:
        graph=Graph(rooms)
        graph.dfs(0)
        
        for i in graph.visited:
            if not i:
                return False
        return True