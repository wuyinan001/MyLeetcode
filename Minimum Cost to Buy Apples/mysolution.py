import heapq

class Solution:
    def minCost(self, n: int, roads: List[List[int]], appleCost: List[int], k: int) -> List[int]:
        pq=[]
        heapq.heapify(pq)
        
        adj=[[] for _ in range(n)]
        ans=[float('inf') for _ in range(n)]
        
        for u,v,w in roads:
            adj[u-1].append((v-1,w))
            adj[v-1].append((u-1,w))
        
        for i in range(n):
            dist=[float('inf') for _ in range(n)]
            dist[i]=0
            
            heapq.heappush(pq,(0,i))
            
            while pq:
                d,u=heapq.heappop(pq)
                ans[i]=min(ans[i],(1+k)*d+appleCost[u])
                for v,d2 in adj[u]:
                    if dist[v]>d2+dist[u]:
                        dist[v]=d2+dist[u]
                        heapq.heappush(pq,(dist[v],v))
        
        return ans