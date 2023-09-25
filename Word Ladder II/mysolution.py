class Solution:
    
    def oneDiff(self,s1,s2):
        diff=0
        for i in range(len(s1)):
            if s1[i]!=s2[i]:
                diff+=1
        
        return diff==1
    
    def printMap(self,adj):
        for key in adj.keys():
            print(key,adj[key])
    
    def backTrack(self,ans,list1,beginWord,word,prev):
        if word==beginWord:
            newlist=list1[:]
            #print(newlist)
            newlist.append(word)
            newlist.reverse()
            ans.append(newlist)
            return
        
        list1.append(word)
        
        for w in prev[word]:
            self.backTrack(ans,list1,beginWord,w,prev)
        
        list1.pop()
        
        
    
    def findLadders(self, beginWord: str, endWord: str, wordList: List[str]) -> List[List[str]]:
        
        if endWord not in wordList:
            return None
        
        adj={}
        dist={}
        prev={}
        
        adj[beginWord]=[]
        dist[beginWord]=0
        prev[beginWord]=[]
        
        for i in wordList:
            if i!=beginWord:
                adj[i]=[]
                dist[i]=inf
                prev[i]=[]
        
        for i in wordList:
            if i!=beginWord and self.oneDiff(beginWord,i):
                adj[beginWord].append(i)
                adj[i].append(beginWord)
                
        for i in range(len(wordList)):
            for j in range(i+1,len(wordList)):
                if wordList[i]!=beginWord and wordList[j]!=beginWord and self.oneDiff(wordList[i],wordList[j]):
                    adj[wordList[i]].append(wordList[j])
                    adj[wordList[j]].append(wordList[i])
                    
        #self.printMap(adj)
        
        queue=[]
        
        queue.append(beginWord)
        d=0
        
        while len(queue)!=0:
            word=queue.pop(0)
            for w in adj[word]:
                if dist[w]>=dist[word]+1:
                    if dist[w]>dist[word]+1:
                        dist[w]=1+dist[word]
                        queue.append(w)
                    prev[w].append(word)
                    
        #self.printMap(prev)
        
        ans=[]
        self.backTrack(ans,[],beginWord,endWord,prev)
                    
        return ans