class Solution {
    public int longestValidParentheses(String s) 
    {
        int n=s.length();
        
        if(n<=1)
            return 0;
        
        // dp[i]: length of longest valid parentheses ending at s[i]
        int[] dp=new int[n];
        
        dp[0]=0;
        
        if(s.charAt(0)=='('&&s.charAt(1)==')')
            dp[1]=2;
        
        int max=dp[1];
        
        for(int i=2;i<n;i++)
        {
            if(s.charAt(i)==')'&&s.charAt(i-1)=='(')
            {
                dp[i]=dp[i-2]+2;
            }
            else if(s.charAt(i)==')'&&s.charAt(i-1)==')')
            {
                if(i-1-dp[i-1]>=0&&s.charAt(i-1-dp[i-1])=='(')
                {
                    if(i-1-dp[i-1]==0)
                        dp[i]=dp[i-1]+2;
                    else
                        dp[i]=dp[i-1]+2+dp[i-2-dp[i-1]];
                }   
            }
            
            if(max<dp[i])
                max=dp[i];
        }
        
        return max;
    }
}