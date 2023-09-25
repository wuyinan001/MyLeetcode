class Solution:
    def backTrack(self,left,right,target,s,list1):
        if left+right==target:
            if left==right:
                list1.append(s)
            return
        
        if left>right:
            self.backTrack(left,right+1,target,s+")",list1)
        
        self.backTrack(left+1,right,target,s+"(",list1)
        
    def generateParenthesis(self, n: int) -> List[str]:
        ans=[]
        
        self.backTrack(0,0,2*n,"",ans)
        
        return ans