class Graph:
    def __init__(self,n,parent,value):
        self.V=n
        self.adj=[[] for i in range(n)]
        self.value=value
        self.mark=[False for i in range(n)]
        self.count=[-1 for i in range(n)]
        self.remove=0

        for i in range(n):
            if parent[i]!=-1:
                self.adj[parent[i]].append(i)

    def dfs1(self,u):
        sum1=self.value[u]
        count=1
        for v in self.adj[u]:
            pair=self.dfs1(v)
            sum1+=pair[0]
            count+=pair[1]

        if sum1==0:
            self.mark[u]=True
        
        self.count[u]=count

        return (sum1,count)
    
    def dfs2(self,u):
        if self.mark[u]:
            self.remove+=self.count[u]
        else:
            for v in self.adj[u]:
                self.dfs2(v)

class Solution:
    def deleteTreeNodes(self, nodes: int, parent: List[int], value: List[int]) -> int:
        g=Graph(nodes,parent,value)
        g.dfs1(0)
        g.dfs2(0)
        return nodes-g.remove