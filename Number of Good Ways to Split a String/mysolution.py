class Solution:
    def numSplits(self, s: str) -> int:
        n=len(s)
        prefix={}
        suffix={}
        
        ans=0

        for i in range(n):
            suffix[s[i]]=suffix.get(s[i],0)+1
        
        for i in range(n-1):
            prefix[s[i]]=prefix.get(s[i],0)+1
            if suffix[s[i]]==1:
                del suffix[s[i]]
            else:
                suffix[s[i]]-=1
            
            if len(prefix)==len(suffix):
                ans+=1
        
        return ans