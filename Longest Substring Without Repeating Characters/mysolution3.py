class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        set1=set([])
        n=len(s)
        
        start=0
        end=0
        ans=0
        
        while end<n:
            c=s[end]
            if c in set1:
                ans=max(ans,end-start)
                while c in set1:
                    set1.remove(s[start])
                    start+=1
                    
            set1.add(c)
            end+=1
        
        if len(set1)==(end-start):
            ans=max(ans,len(set1))
        
        return ans