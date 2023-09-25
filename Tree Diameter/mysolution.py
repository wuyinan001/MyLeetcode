from collections import defaultdict
class Solution:
    def bfs(self,u,adj):
        queue=[u]
        visited=set([u])
        step=0

        while queue:
            size=len(queue)
            for _ in range(size):
                curr=queue.pop(0)
                for v in adj[curr]:
                    if v not in visited:
                        visited.add(v)
                        queue.append(v)
            step+=1
        
        return (curr,step-1)

    def treeDiameter(self, edges: List[List[int]]) -> int:
        if len(edges)==0:
            return 0
            
        adj=defaultdict(list)

        for i,j in edges:
            adj[i].append(j)
            adj[j].append(i)
        
        farthest,step1=self.bfs(edges[0][0],adj)
        _,step2=self.bfs(farthest,adj)

        return step2