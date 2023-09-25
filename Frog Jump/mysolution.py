class Solution:
    def canCross(self, stones: List[int]) -> bool:
        if stones[1]!=1:
            return False
        
        map1={}
        n=len(stones)
        
        for i in stones:
            map1[i]=set([])
        
        map1[1].add(1)
        
        for i in range(1,n):
            for pre_jump in map1[stones[i]]:
                for jump in range(pre_jump-1,pre_jump+2):
                    if jump>0 and stones[i]+jump in map1:
                        map1[stones[i]+jump].add(jump)
        
        return len(map1[stones[n-1]])>0