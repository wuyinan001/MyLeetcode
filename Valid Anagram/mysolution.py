class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        
        if len(s)!=len(t):
            return False
        
        n=len(s)
        
        freq=[0 for i in range(26)]
        
        for i in range(n):
            freq[ord(s[i])-ord('a')]+=1
        
        for i in range(n):
            freq[ord(t[i])-ord('a')]-=1
            if freq[ord(t[i])-ord('a')]<0:
                return False
        
        return True