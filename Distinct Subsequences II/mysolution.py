class Solution:
    def distinctSubseqII(self, s: str) -> int:
        n=len(s)
        MOD=int(1e9+7)
        # dp[i]: num of distinct subseq from index 0 to index i-1, including ""
        dp=[0 for i in range(n+1)]
        
        dp[0]=1
        
        # dict1[c] contains the last index of character c
        dict1={}
        
        for i in range(1,n+1):
            dp[i]=(2*dp[i-1])%MOD
            # if s[i-1] occurs before and the prev s[i-1] is at index j, then dp[j]
            # (the num of distinct subseq before the last s[i-1]) is counted twice
            if s[i-1] in dict1:
                dp[i]-=dp[dict1[s[i-1]]]
                # since dp[i] is modulo, dp[i] may be smaller than dp[dict1[s[i-1]]],
                # if so, then dp[i] needs to add MOD after minus dp[dict1[s[i-1]]]
                if dp[i]<0:
                    dp[i]+=MOD
            
            dict1[s[i-1]]=i-1
        
        # subtract "" from final count because "" is not included as non-empty subsequences
        return dp[n]-1