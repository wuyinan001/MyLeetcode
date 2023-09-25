class Solution:
    def __init__(self):
        self.adj={}
        self.name={}
        self.cmp_dict={}
        self.cmp=0
        self.visited=set([])

    def dfs1(self,u):
        self.visited.add(u)
        self.cmp_dict[self.cmp].append(u)

        for v in self.adj[u]:
            if v not in self.visited:
                self.dfs1(v)
    
    def dfs2(self):
        for u in self.adj:
            if u not in self.visited:
                self.cmp+=1
                self.cmp_dict[self.cmp]=[]
                self.dfs1(u)

    def accountsMerge(self, accounts: List[List[str]]) -> List[List[str]]:
        V=0
        for a in accounts:
            n1=len(a)
            for i in range(1,n1):
                if a[i] not in self.adj:
                    self.adj[a[i]]=set([])
                    
                if a[i] not in self.name:
                    self.name[a[i]]=a[0]
            
            for i in range(1,n1-1):
                for j in range(i+1,n1):
                    self.adj[a[i]].add(a[j])
                    self.adj[a[j]].add(a[i])
        
        self.dfs2()

        ans=[]

        for key in self.cmp_dict:
            self.cmp_dict[key].sort()
            self.cmp_dict[key].insert(0,self.name[self.cmp_dict[key][0]])
            ans.append(self.cmp_dict[key])

        return ans

