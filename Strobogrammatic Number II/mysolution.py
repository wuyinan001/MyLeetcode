class Solution:
    # find all strobogrammatic including the ones starting with '0'
    def helper(self,n):
        if n==1:
            return ['0','1','8']
        elif n==2:
            return ['00','11','69','88','96']
        
        ans=[]
        
        list1=self.helper(n-2)
        
        for s in list1:
            ans.append('0'+s+'0')
            ans.append('1'+s+'1')
            ans.append('6'+s+'9')
            ans.append('8'+s+'8')
            ans.append('9'+s+'6')
        
        return ans
        
    def findStrobogrammatic(self, n: int) -> List[str]:
        if n==1:
            return ['0','1','8']
        
        list1=self.helper(n)
        ans=[]
        
        for s in list1:
            if s[0]!='0':
                ans.append(s)
        
        return ans