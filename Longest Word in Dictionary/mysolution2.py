class Solution:
    def longestWord(self, words: List[str]) -> str:
        set1=set([])
        
        for w in words:
            set1.add(w)
            
        ans=[]
        
        for w in words:
            n=len(w)
            if n==1:
                ans.append(w)
            else:
                i=0
                while i<n:
                    if w[:i+1] not in set1:
                        break
                    i+=1
                if i==n:
                    ans.append(w)
        
        if not ans:
            return ""
        
        ans.sort(key=lambda x:(-len(x),x))
        
        return ans[0]