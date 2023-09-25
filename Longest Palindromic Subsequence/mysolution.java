class Solution {
    public int longestPalindromeSubseq(String s) {
        int n=s.length();
        
        if(n==0)
            return 0;
        
        // L[i][j] shows the length of longest palindromic subsequence from i to j
        // if s[i]=s[j], L[i][j]=2+L[i+1][j-1];
        // if s[i]!=s[j], L[i][j]=max{L[i+1][j],L[i][j-1]};
        int[][] L=new int[n][n];
        int max=1;
        
        for(int i=0;i<n;i++)
            L[i][i]=1;
        
        for(int i=0;i<n-1;i++)
        {
            if(s.substring(i,i+1).equals(s.substring(i+1,i+2)))
                L[i][i+1]=2;
            else
                L[i][i+1]=1;
            
            if(max<L[i][i+1])
                max=L[i][i+1];
        }
        
        for(int gap=2;gap<n;gap++)
        {
            for(int i=0;i<n-gap;i++)
            {
                int j=i+gap;
                
                if(s.substring(i,i+1).equals(s.substring(j,j+1)))
                    L[i][j]=2+L[i+1][j-1];
                else
                {
                    if(L[i][j-1]<L[i+1][j])
                        L[i][j]=L[i+1][j];
                    else
                        L[i][j]=L[i][j-1];
                }
                
                if(max<L[i][j])
                    max=L[i][j];
            }
        }
        
        return max;
    }
}