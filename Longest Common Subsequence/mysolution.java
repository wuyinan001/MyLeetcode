class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        
        // L[i][j] shows the length of LCS for the strings ending at index i-1 and j-1.
        int[][] L=new int[n+1][m+1];
        
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=m;j++)
            {
                if(text1.substring(i-1,i).equals(text2.substring(j-1,j)))
                    L[i][j]=L[i-1][j-1]+1;
                else
                {
                    L[i][j]=L[i-1][j];
                    if(L[i][j]<L[i][j-1])
                        L[i][j]=L[i][j-1];
                }
            }
        }
        
        return L[n][m];
    }
}