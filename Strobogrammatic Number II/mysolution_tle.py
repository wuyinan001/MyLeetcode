class Solution:
    def same(self,s):
        s2=""
        
        for c in s:
            if c=='6':
                s2='9'+s2
            elif c=='9':
                s2='6'+s2
            else:
                s2=c+s2
        
        return s==s2
        
    def backTrack(self,s,size,n_s,list1):
        #print("s",s)
        if len(s)==size:
            if self.same(s):
                list1.append(s)
            return
        
        for a in n_s:
            if s!='0':
                self.backTrack(s+a,size,n_s,list1)
            
        
    def findStrobogrammatic(self, n: int) -> List[str]:
        ans=[]
        n_s=['0','1','6','8','9']
        
        self.backTrack("",n,n_s,ans)
        
        return ans