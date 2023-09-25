class Solution:
    def isAlienSorted(self, words: List[str], order: str) -> bool:
        n=len(order)
        dict1={}
        
        for i in range(n):
            dict1[order[i]]=i
        
        m=len(words)
        
        for i in range(m-1):
            w1=words[i]
            w2=words[i+1]
            n1=len(w1)
            n2=len(w2)
            
            if n2<n1 and w2==w1[:n2]:
                return False
            
            for j in range(min(n1,n2)):
                if w1[j]!=w2[j]:
                    if dict1[w1[j]]>dict1[w2[j]]:
                        return False
                    break
        
        return True