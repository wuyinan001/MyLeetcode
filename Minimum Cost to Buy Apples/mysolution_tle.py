import heapq

class Solution:
    def mindist(self,u,adj,dist):
        pq=[]
        heapq.heapify(pq)
        
        class Obj:
            def __init__(self,u):
                self.u=u
            
            def __lt__(self,other):
                return dist[self.u]<dist[other.u]
        
        dist[u][u]=0
        
        heapq.heappush(pq,Obj(u))
        
        while pq:
            curr=heapq.heappop(pq)
            for v in adj[curr.u]:
                if dist[u][v[0]]>v[1]+dist[u][curr.u]:
                    dist[u][v[0]]=v[1]+dist[u][curr.u]
                    heapq.heappush(pq,Obj(v[0]))
        
        
    def minCost(self, n: int, roads: List[List[int]], appleCost: List[int], k: int) -> List[int]:
        dist=[[float('inf') for _ in range(n+1)] for _ in range(n+1)]
        
        adj={}
        
        for i in range(1,n+1):
            adj[i]=[]
            
        for r in roads:
            adj[r[0]].append((r[1],r[2]))
            adj[r[1]].append((r[0],r[2]))
            
        for i in range(1,n+1):
            self.mindist(i,adj,dist)
            
        #print(dist)
        
        ans=[float('inf') for _ in range(n)]
        
        for i in range(1,n+1):
            for j in range(1,n+1):
                ans[i-1]=min(ans[i-1],appleCost[j-1]+dist[i][j]*(1+k))
        
        return ans
