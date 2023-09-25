class Solution:
    
    def __init__(self):
        self.set=set([])
        self.maxLen=0
    
    def backTrack(self,s,index,left,right,list1):
        if index==len(s):
            if left==right and len(list1)>=self.maxLen:
                if len(list1)>self.maxLen:
                    self.maxLen=len(list1)
                    self.set.clear()
                self.set.add(''.join(list1))
            return
        
        c=s[index]
        if c!="(" and c!=")":
            list1.append(c)
            self.backTrack(s,index+1,left,right,list1)
            list1.pop()
        elif c=="(":    
            self.backTrack(s,index+1,left,right,list1)
            list1.append(c)
            self.backTrack(s,index+1,left+1,right,list1)
            list1.pop()
        else:
            self.backTrack(s,index+1,left,right,list1)
            if left>right:
                list1.append(c)
                self.backTrack(s,index+1,left,right+1,list1)
                list1.pop()
        
        
    def removeInvalidParentheses(self, s: str) -> List[str]:
        self.backTrack(s,0,0,0,[])
        ans=[]
        
        for s in self.set:
            ans.append(s)
        
        return ans