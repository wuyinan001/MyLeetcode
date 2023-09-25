class Solution {
    public int maxPower(String s) {
        
        int n=s.length();
        
        // dp[i]: the power of substring ends at i
        int[] dp=new int[n];
        
        dp[0]=1;
        
        for(int i=1;i<n;i++)
        {
            if(s.charAt(i)==s.charAt(i-1))
                dp[i]=1+dp[i-1];
            else
                dp[i]=1;
        }
        
        int max=1;
        
        for(int i=1;i<n;i++)
            max=Math.max(dp[i],max);
        
        return max;
    }
}