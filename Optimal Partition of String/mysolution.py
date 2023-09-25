class Solution:
    def partitionString(self, s: str) -> int:
        n=len(s)
        set1=set([])
        
        ans=0
        
        for i in range(n):
            if s[i] in set1:
                ans+=1
                set1.clear()
            set1.add(s[i])
        
        if len(set1)!=0:
            ans+=1
            
        return ans