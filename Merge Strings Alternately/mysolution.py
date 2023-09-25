class Solution:
    def mergeAlternately(self, word1: str, word2: str) -> str:
        ans=[]
        n1=len(word1)
        n2=len(word2)
        
        i=0
        j=0
        
        while i<n1 and j<n2:
            if i==j:
                ans.append(word1[i])
                i+=1
            else:
                ans.append(word2[j])
                j+=1
        
        while i<n1:
            ans.append(word1[i])
            i+=1
            
        while j<n2:
            ans.append(word2[j])
            j+=1
        
        return ''.join(ans)