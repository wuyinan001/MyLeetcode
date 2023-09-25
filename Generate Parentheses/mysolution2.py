class Solution:
    def backTrack(self,s,target,left,right,list1):
        if len(s)==target:
            list1.append(s)
            return
        
        if left>right:
            self.backTrack(s+')',target,left,right+1,list1)
            
        if left<target//2:
            self.backTrack(s+'(',target,left+1,right,list1)
        
    def generateParenthesis(self, n: int) -> List[str]:
        ans=[]
        self.backTrack("",n*2,0,0,ans)
        
        return ans