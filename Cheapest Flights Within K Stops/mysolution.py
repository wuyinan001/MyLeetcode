class Solution:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        dist={}
        
        for i in range(n):
            dist[i]=inf
        
        dist[src]=0
        
        adj={}
        
        for i in range(n):
            adj[i]=[]
        
        for f in flights:
            adj[f[0]].append([f[1],f[2]])
        
        queue=[]
        # 0: node, 1: step, 2: dist
        queue.append([src,0,0])
        step=0
        
        
        while queue:
            if step==k+1:
                break
                
            size=len(queue)
            
            for i in range(size):
                temp=queue.pop(0)
                node=temp[0]
                curr=temp[1]
                d=temp[2]
                for v in adj[node]:
                    # Explore the neighbors only when finding a shorter path to that neighbor
                    if d+v[1]<dist[v[0]]:
                        queue.append([v[0],curr+1,d+v[1]])
                        # Update the shortest distance to that node only when that node is <=(k+1) steps from src node
                        if curr+1<=k+1:
                            dist[v[0]]=d+v[1]
            
            #print(dist)
            step+=1
            
            
        return dist[dst] if dist[dst]!=inf else -1