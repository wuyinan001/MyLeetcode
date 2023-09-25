class Solution:
    def minWindow(self, s: str, t: str) -> str:
        map1={}
        map2={}
        for i in t:
            map2[i]=map2.get(i,0)+1
        
        start=0
        end=0
        ans=""
        length=inf
        meet=0
        n=len(s)
        
        while end<n:
            c=s[end]
            map1[c]=map1.get(c,0)+1
            if c in map2 and map1[c]==map2[c]:
                meet+=1
            
            if meet==len(map2):
                while meet==len(map2):
                    c2=s[start]
                    map1[c2]-=1
                    if c2 in map2 and map2[c2]>map1[c2]:
                        meet-=1
                    start+=1
                    
                if length>end-start+2:
                    length=end-start+2
                    ans=s[start-1:end+1]
            
            end+=1
        
        return ans