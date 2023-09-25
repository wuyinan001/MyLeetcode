class Solution:
    
    def __init__(self):
        self.ans=0
    
    def dfs(self,freq):
        for i in range(26):
            if freq[i]==0:
                continue
            
            self.ans+=1
            freq[i]-=1
            self.dfs(freq)
            freq[i]+=1
            
    
    def numTilePossibilities(self, tiles: str) -> int:
        freq=[0 for i in range(26)]
        for i in tiles:
            freq[ord(i)-ord('A')]+=1
        
        self.dfs(freq)
        return self.ans