class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        map1={}
        n=len(s)
        start=0
        end=0
        # the max frequency of a certain char appeared in a give window [start,end] so far
        maxFreq=0
        ans=0
        
        while end<n:
            c=s[end]
            map1[c]=map1.get(c,0)+1
            maxFreq=max(maxFreq,map1[c])
            
            if end-start+1-maxFreq==k+1:
                ans=max(ans,end-start)
                map1[s[start]]-=1
                start+=1
            
            end+=1
        
        if end-start-maxFreq<=k:
            ans=max(ans,end-start)
        
        return ans