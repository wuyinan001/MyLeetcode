class Solution:
    def numSplits(self, s: str) -> int:
        n=len(s)
        set1=set([])
        prefix=[0 for _ in range(n)]
        suffix=[0 for _ in range(n)]
        
        for i in range(n):
            set1.add(s[i])
            prefix[i]=len(set1)
        
        set1.clear()
        
        for i in range(n-1,-1,-1):
            set1.add(s[i])
            suffix[i]=len(set1)
            
        ans=0
        
        for i in range(n-1):
            if prefix[i]==suffix[i+1]:
                ans+=1
        
        return ans