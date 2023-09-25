class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        n=len(s)
        dp=[False for i in range(n+1)]
        dp[0]=True
        
        maxLen=0
        
        for word in wordDict:
            maxLen=max(maxLen,len(word))
        
        for i in range(1,n+1):
            for j in range(i-1,-1,-1):
                if i-j>maxLen:
                    break
                if s[j:i] in wordDict and dp[j]:
                    dp[i]=True
                    break
        
        return dp[n]