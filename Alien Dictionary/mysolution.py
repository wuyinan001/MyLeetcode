class Solution:
    
    def __init__(self):
        self.V=0
        self.adj={}
        self.visited={}
        self.postOrder={}
        self.clock=0
    
    def dfs(self,u):
        self.visited[u]=True
        self.clock+=1
        
        for v in self.adj[u]:
            if not self.visited[v]:
                self.dfs(v)
        
        self.clock+=1
        self.postOrder[u]=self.clock
        
    def dfs2(self):
        for u in self.adj.keys():
            if not self.visited[u]:
                self.dfs(u)
    
    def alienOrder(self, words: List[str]) -> str:
        n=len(words)
        
        for word in words:
            for c in word:
                if c not in self.adj.keys():
                    self.adj[c]=[]
                    self.visited[c]=False
                    self.postOrder[c]=-1
        
        for i in range(n-1):
            word1=words[i]
            word2=words[i+1]
            if len(word2)<len(word1) and word2==word1[:len(word2)]:
                return ""
            
            min_len=min(len(word1),len(word2))
            for j in range(min_len):
                if word1[j]!=word2[j]:
                    self.adj[word1[j]].append(word2[j])
                    break

        self.dfs2()
        
        '''
        for k,v in self.postOrder.items():
            print(k,":",v)
        '''
        
        for u in self.adj.keys():
            for v in self.adj[u]:
                if self.postOrder[u]<self.postOrder[v]:
                    return ""
        
        ans=list(self.adj.keys())
        
        ans.sort(key=lambda x:-self.postOrder[x])
        
        return "".join(ans)