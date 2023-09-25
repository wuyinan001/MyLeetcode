class Solution:
    def isPalindrome(self, s: str) -> bool:
        n=len(s)
        i=0
        j=n-1
        s=s.lower()
        
        while True:
            while i<n and not s[i].isdigit() and not s[i].isalpha():
                i+=1
            
            while j>=0 and not s[j].isdigit() and not s[j].isalpha():
                j-=1
            
            if i>j:
                break
            
            if s[i]!=s[j]:
                return False
            
            i+=1
            j-=1
            
        return True