class Solution:
    def accountsMerge(self, accounts: List[List[str]]) -> List[List[str]]:
        n=len(accounts)
        adj=[set([]) for _ in range(n)]
        visited=[False for _ in range(n)]
        
        for i in range(n):
            for j in range(i+1,n):
                if accounts[i][0]==accounts[j][0]:
                    for a1 in accounts[i][1:]:
                        for a2 in accounts[j][1:]:
                            if a1==a2:
                                adj[i].add(j)
                                adj[j].add(i)
        
        ans=[]
        
        for i in range(n):
            if not visited[i]:
                visited[i]=True
                set1=set([])
                
                queue=[i]
                
                while queue:
                    u=queue.pop(0)
                    for s in accounts[u][1:]:
                        set1.add(s)
                    
                    for v in adj[u]:
                        if not visited[v]:
                            visited[v]=True
                            queue.append(v)
                
                list1=[]
                for s in set1:
                    list1.append(s)
                    
                list1.sort()   
                list1.insert(0,accounts[i][0])
                ans.append(list1)
        
        return ans