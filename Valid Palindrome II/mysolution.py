class Solution:
    def validPalindrome(self, s: str) -> bool:
        used=False
        
        n=len(s)
        
        i=0
        j=n-1
        
        while True:
            if i>=j:
                return True
            
            if s[i]!=s[j]:
                if used:
                    break
                else:
                    used=True
                    i+=1
            else:
                i+=1
                j-=1
        
        used=False
        i=0
        j=n-1
        while True:
            if i>=j:
                return True
            
            if s[i]!=s[j]:
                if used:
                    return False
                else:
                    used=True
                    j-=1
            else:
                i+=1
                j-=1
        
        return False