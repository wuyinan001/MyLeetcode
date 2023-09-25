class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        freq1={}
        freq2={}
        
        for c in s1:
            freq1[c]=freq1.get(c,0)+1
        
        n1=len(s1)
        n2=len(s2)
        end=0
        
        meet=0
        
        while end<n2:
            c=s2[end]
            freq2[c]=freq2.get(c,0)+1
            if c in freq1 and freq1[c]==freq2[c]:
                meet+=1
            
            if end>=n1:
                c2=s2[end-n1]
                if c2 in freq1 and freq2[c2]==freq1[c2]:
                    meet-=1
                freq2[c2]-=1
                
            if meet==len(freq1):
                return True
            
            end+=1
            
        return False