# The read4 API is already defined for you.
# def read4(buf4: List[str]) -> int:

class Solution:
    
    def __init__(self):
        self.readIndex=0
        self.writeIndex=0
        self.buf4=[None,None,None,None]
    
    def read(self, buf: List[str], n: int) -> int:
        
        for i in range(n):
            if self.readIndex==self.writeIndex:
                self.readIndex=0
                self.writeIndex=read4(self.buf4)
                if self.writeIndex==0:
                    return i
            
            buf[i]=self.buf4[self.readIndex]
            self.readIndex+=1
        
        return n