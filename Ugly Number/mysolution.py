class Solution:
    def isUgly(self, n: int) -> bool:
        if n<=0:
            return False

        if n==1:
            return True
        
        if n%2!=0 and n%3!=0 and n%5!=0:
            return False
        
        if n%2==0 and self.isUgly(int(n/2)):
            return True
        
        if n%3==0 and self.isUgly(int(n/3)):
            return True
        
        if n%5==0 and self.isUgly(int(n/5)):
            return True
        
        return False