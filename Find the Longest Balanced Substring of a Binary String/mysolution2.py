class Solution:
    def findTheLongestBalancedSubstring(self, s: str) -> int:
        ans=0
        temp="01"
        
        while len(temp)<=len(s):
            if temp in s:
                ans=max(len(temp),ans)
                temp="0"+temp+"1"
            else:
                break
        
        return ans