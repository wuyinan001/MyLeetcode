class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> List[str]:
        if s=="":
            return [""]
        
        n=len(s)
        dp=[False for _ in range(n+1)]
        
        ans=[]
        
        dp[0]=True
        
        for i in range(1,n+1):
            for j in range(i):
                if dp[j] and s[j:i] in wordDict:
                    dp[i]=True
                    if i==n:
                        list1=self.wordBreak(s[:j],wordDict)
                        for str1 in list1:
                            if str1=="":
                                ans.append(s[j:i])
                            else:
                                ans.append(str1+" "+s[j:i])
        
        return ans