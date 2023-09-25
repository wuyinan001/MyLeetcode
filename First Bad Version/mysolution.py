# The isBadVersion API is already defined for you.
# def isBadVersion(version: int) -> bool:

class Solution:
    def findBad(self,lo,hi):
        if lo==hi:
            return lo
        
        mid=(lo+hi)//2
        
        b=isBadVersion(mid)
        
        if not b:
            return self.findBad(mid+1,hi)
        else:
            return self.findBad(lo,mid)
        
    def firstBadVersion(self, n: int) -> int:
        return self.findBad(1,n)