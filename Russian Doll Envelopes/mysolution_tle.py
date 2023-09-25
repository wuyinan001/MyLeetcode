class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        envelopes.sort(key=lambda x:(x[0],-x[1]))
        n=len(envelopes)
        
        L=[1 for i in range(n)]
        
        for i in range(1,n):
            for j in range(i):
                if envelopes[i][1]>envelopes[j][1]:
                    L[i]=max(L[i],1+L[j])
        
        return max(L)