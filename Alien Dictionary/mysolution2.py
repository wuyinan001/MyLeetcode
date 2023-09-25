class Graph:
    def __init__(self):
        self.adj={}
        self.postOrder={}
        self.visited={}
        self.clock=0
        self.cycle=False
    
    def dfs(self,u):
        self.visited[u]=True
        self.clock+=1
        
        for v in self.adj[u]:
            if not self.visited[v]:
                self.dfs(v)
        
        self.clock+=1
        self.postOrder[u]=self.clock

class Solution:
    def alienOrder(self, words: List[str]) -> str:
        n=len(words)
        g=Graph()
        
        for word in words:
            for i in word:
                if i not in g.adj:
                    g.adj[i]=[]
                    g.postOrder[i]=-1
                    g.visited[i]=False
        
        for i in range(n-1):
            # e.g., ["abc","ab"]
            if len(words[i+1])<len(words[i]) and words[i+1]==words[i][:len(words[i+1])]:
                return ""
            
            for j in range(min(len(words[i]),len(words[i+1]))):
                if words[i][j]!=words[i+1][j]:
                    g.adj[words[i][j]].append(words[i+1][j])
                    break
        
        for u in g.adj:
            if not g.visited[u]:
                g.dfs(u)
        
        for u in g.adj:
            for v in g.adj[u]:
                if g.postOrder[u]<=g.postOrder[v]:
                    return ""
        
        ans=list(g.adj.keys())
        ans.sort(key=lambda x:-g.postOrder[x])
        
        return "".join(ans)