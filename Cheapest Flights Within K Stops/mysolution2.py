class Solution:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        #dist[i]: min distance to node i
        dist=[float('inf') for i in range(n)]

        # adj[x][0]: next node; adj[x][1]: distance
        adj={}

        for i in range(n):
            adj[i]=[]

        for f in flights:
            adj[f[0]].append([f[1],f[2]])
        
        # 0: node; 1: num of stops; 2: distance from current path to node
        queue=[(src,0,0)]

        dist[src]=0
        step=0

        while queue:
            if step==k+1:
                break
            size=len(queue)
            for i in range(size):
                # distance: the distance from current path to node. This is different from
                # dist[node]
                node,stops,distance=queue.pop(0)
                for v,d in adj[node]:
                    if dist[v]>distance+d and stops+1<=k+1:
                        dist[v]=distance+d
                        #print("v",v,"dist",dist[v],"stops",stops)
                        queue.append((v,stops+1,distance+d))
            step+=1

        return dist[dst] if dist[dst]!=float('inf') else -1