class Solution:
    def lengthOfLongestSubstringKDistinct(self, s: str, k: int) -> int:
        n=len(s)
        dict1={}
        
        end=0
        start=0
        
        ans=0
        
        while end<n:
            c=s[end]
            dict1[c]=dict1.get(c,0)+1
            if len(dict1)>k:
                ans=max(ans,end-start)
                while len(dict1)>k:
                    c1=s[start]
                    if dict1[c1]==1:
                        del dict1[c1]
                    else:
                        dict1[c1]-=1
                    start+=1
            end+=1
        
        if len(dict1)<=k:
            ans=max(ans,end-start)
        
        return ans