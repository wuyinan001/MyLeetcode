class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        n=len(s)
        start=0
        end=0
        ans=0
        dict1={}
        
        while end<n:
            c=s[end]
            if c not in dict1:
                dict1[c]=1
            else:
                dict1[c]+=1
            
            if dict1[c]>1:
                ans=max(ans,end-start)
                while dict1[c]>1:
                    c2=s[start]
                    if dict1[c2]==1:
                        del dict1[c2]
                    else:
                        dict1[c2]-=1
                    start+=1
            
            end+=1
        
        if len(dict1)==end-start:
            ans=max(ans,end-start)
        
        return ans