class Solution:
    def findMinHeightTrees(self, n: int, edges: List[List[int]]) -> List[int]:
        adj=[[] for _ in range(n)]
        
        for u,v in edges:
            adj[u].append(v)
            adj[v].append(u)
            
        leaves=[]
        
        for i in range(n):
            if len(adj[i])<=1:
                leaves.append(i)
                
        totalNodes=n
        
        while totalNodes>2:
            totalNodes-=len(leaves)
            size=len(leaves)
            for _ in range(size):
                curr=leaves.pop(0)
                neighbor=adj[curr].pop()
                adj[neighbor].remove(curr)
                
                if len(adj[neighbor])==1:
                    leaves.append(neighbor)
                
        return leaves