from collections import defaultdict

class Solution:
    def findfarthest(self,u,adj,curr):
        queue=[u]
        visited=set([u])
        step=0
        farthest=u

        while queue:
            size=len(queue)
            for _ in range(size):
                farthest=queue.pop(0)

                for v in adj[farthest]:
                    if v not in visited and v in curr:
                        queue.append(v)
                        visited.add(v)
            
            step+=1
        
        valid=len(visited)

        return (step-1,farthest,valid)


    def countSubgraphsForEachDiameter(self, n: int, edges: List[List[int]]) -> List[int]:
        adj=defaultdict(set)
        for edge in edges:
            adj[edge[0]].add(edge[1])
            adj[edge[1]].add(edge[0])
        
        N=2**n
        aset=[i for i in range(1,n+1)]
        ans=[0 for i in range(n-1)]

        for i in range(N):
            k=i
            index=0
            # curr: subset of node indexs in bitmask of i
            curr=set([])
            while k:
                if k&1:
                    curr.add(aset[index])
                k=k>>1
                index+=1
            
            if not curr:
                continue
            
            step1,farthest1,valid1=self.findfarthest(next(iter(curr)),adj,curr)
            step2,_,valid2=self.findfarthest(farthest1,adj,curr)

            # print("curr",curr)
            # print("step",step2)
            # print("farthest",farthest1)

            if step2>0 and valid2==len(curr):
                ans[step2-1]+=1
        
        return ans