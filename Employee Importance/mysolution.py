"""
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""

class Solution:
    def __init__(self):
        # the adj dictionary: id:list of subordinates
        self.adj={}
        # the importance dictionary: id:importance
        self.importance={}

    def dfs(self,u):
        ans=self.importance[u]
        for v in self.adj[u]:
            ans+=self.dfs(v)
        
        return ans

    def getImportance(self, employees: List['Employee'], id: int) -> int:
        for e in employees:
            self.adj[e.id]=[]
            self.importance[e.id]=e.importance
            for v in e.subordinates:
                self.adj[e.id].append(v)
        
        return self.dfs(id)