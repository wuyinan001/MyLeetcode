class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int n=s.length();
        
        if(n<=1)
            return n;
        
        // In case s is longer than 128.
        if(n>128)
        {
            s=s.substring(0,128);
            n=128;
        }
        
        boolean[][] L=new boolean[n][n];
        
        for(int i=0;i<n;i++)
            L[i][i]=true;
        
        int max=1;
        
        for(int k=1;k<=n-1;k++)
        {
            for(int i=0;i<n-k;i++)
            {
                int j=i+k;
                if(L[i+1][j]&&L[i][j-1]&&(s.charAt(i)!=s.charAt(j)))
                {
                    L[i][j]=true;
                    if(max<j-i+1)
                        max=j-i+1;
                }
            }
            
            if(max<k+1)
            {
                return max;
            }
                
        }
        
        return max;
    }
}