class Solution:
    def minDominoRotations(self, tops: List[int], bottoms: List[int]) -> int:
        n=len(tops)
        # min flips to make all top==tops[0]
        topA=0
        # min flips to make all top==bottoms[0]
        topB=0
        # min flips to make all bottom==tops[0]
        bottomA=0
        # min flips to make all bottom==bottoms[0]
        bottomB=0
        
        for i in range(n):
            if tops[i]!=tops[0] and bottoms[i]!=tops[0]:
                topA=inf
                break
            elif tops[i]!=tops[0]:
                topA+=1
        
        for i in range(n):
            if tops[i]!=bottoms[0] and bottoms[i]!=bottoms[0]:
                topB=inf
                break
            elif tops[i]!=bottoms[0]:
                topB+=1
        
        for i in range(n):
            if tops[i]!=tops[0] and bottoms[i]!=tops[0]:
                bottomA=inf
                break
            elif bottoms[i]!=tops[0]:
                bottomA+=1
        
        for i in range(n):
            if tops[i]!=bottoms[0] and bottoms[i]!=bottoms[0]:
                bottomB=inf
                break
            elif bottoms[i]!=bottoms[0]:
                bottomB+=1
        
        ans=min(topA,topB,bottomA,bottomB)
        return ans if ans!=inf else -1