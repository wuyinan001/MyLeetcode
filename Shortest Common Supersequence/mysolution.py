class Solution:
    def shortestCommonSupersequence(self, str1: str, str2: str) -> str:
        n1=len(str1)
        n2=len(str2)
        
        L=[[0 for j in range(n2+1)] for i in range(n1+1)]
        
        for i in range(n1):
            for j in range(n2):
                if str1[i]==str2[j]:
                    L[i+1][j+1]=1+L[i][j]
                else:
                    L[i+1][j+1]=max(L[i+1][j],L[i][j+1])
        
        i=n1-1
        j=n2-1
        ans=[]
        
        while i>=0 and j>=0:
            if str1[i]==str2[j]:
                ans.append(str1[i])
                i-=1
                j-=1
            else:
                if L[i+1][j]>L[i][j+1]:
                    ans.append(str2[j])
                    j-=1
                else:
                    ans.append(str1[i])
                    i-=1
        
        ans.reverse()
        
        if i>=0:
            return str1[:i+1]+''.join(ans)
            
        if j>=0:
            return str2[:j+1]+''.join(ans)
        
        return ''.join(ans)