class Solution:
    def convert(self,s):
        strs=s.split(":")
        ans=int(strs[0])*60+int(strs[1])
        return ans
        
    def haveConflict(self, event1: List[str], event2: List[str]) -> bool:
        x1=self.convert(event1[0])
        x2=self.convert(event1[1])
        y1=self.convert(event2[0])
        y2=self.convert(event2[1])
        
        if y1>=x1:
            return y1<=x2
        else:
            return x1<=y2