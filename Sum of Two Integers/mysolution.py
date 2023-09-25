class Solution:
    def getSum(self, a: int, b: int) -> int:
        if abs(a)<abs(b):
            return self.getSum(b,a)
        
        x=abs(a)
        y=abs(b)
        sign=1 if a>=0 else -1
        
        if a*b>=0:
            while y!=0:
                x2=x^y
                y2=(x&y)<<1
                x=x2
                y=y2
        else:
            while y!=0:
                x2=x^y
                y2=((~x)&y)<<1
                x=x2
                y=y2
        
        
        return sign*x