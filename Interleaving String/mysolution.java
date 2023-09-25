class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        
        if(s3.equals(""))
            return true;
        
        int n1=s1.length(), n2=s2.length(), n3=s3.length();
        
        // The s3 must contains all the chars in s1 and s2 and no additional chars.
        if(n1+n2!=n3)
            return false;
        
        // dp[i][k]: whether is interleave in s1[0...i-1] and s3[0...k-1]
        boolean[][] dp=new boolean[n1+1][n3+1];
        
        for(int i=0;i<=n1;i++)
            dp[i][0]=true;
        
        for(int k=1;k<=n3;k++)
        {
            for(int i=0;i<=Math.min(k,n1);i++)
            {
                // If dp[i-1][k-1]=true and s1[i-1]==s3[k-1], dp[i][k] is true;
                // Or if dp[i][k-1]=true and s2[k-i-1]==s3[k-1], dp[i][k] is true.
                
                if((i>0&&dp[i-1][k-1]&&s1.charAt(i-1)==s3.charAt(k-1))||((k-i<=n2&&k-i>0)&&dp[i][k-1]&&s2.charAt(k-i-1)==s3.charAt(k-1)))
                {
                    dp[i][k]=true;
                }
            }
        }

        return dp[n1][n3];
        
    }
}