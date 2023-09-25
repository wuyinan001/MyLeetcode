class Solution:
    def __init__(self):
        self.map={}
    
    def maxNumOfSubstrings(self, s: str) -> List[str]:
        n=len(s)
        for i in range(n):
            if s[i] not in self.map.keys():
                self.map[s[i]]=[i,i]
            else:
                self.map[s[i]][1]=i
        
        ans=[]
        old_end=-1
        for i in range(n):
            start_index=self.map[s[i]][0]
            if start_index==i:
                end=self.getEnd(s,i)
                if end!=-1:
                    if end>old_end:
                        ans.append("")
                    ans[-1]=s[i:end+1]
                    old_end=end
        
        return ans
        
    def getEnd(self,s,start):
        if self.map[s[start]][0]<start:
            return -1
        
        end=self.map[s[start]][1]
        
        i=start+1
        while i<=end:
            if self.map[s[i]][0]<start:
                return -1
            end=max(end,self.map[s[i]][1])
            i+=1
        
        return end