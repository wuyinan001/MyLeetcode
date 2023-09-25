class Solution:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        n1=len(text1)
        n2=len(text2)
        
        L=[[0 for _ in range(n2+1)] for _ in range(n1+1)]
        
        for i in range(1,n1+1):
            for j in range(1,n2+1):
                if text1[i-1]==text2[j-1]:
                    L[i][j]=1+L[i-1][j-1]
                else:
                    L[i][j]=max(L[i-1][j],L[i][j-1])
        
        return L[n1][n2]