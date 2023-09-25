class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        
        int n=str1.length(), m=str2.length();
        
        if(n==0)
            return str2;
        
        if(m==0)
            return str1;
        
        int[][] L=new int[n+1][m+1];
        
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=m;j++)
            {
                if(str1.charAt(i-1)==str2.charAt(j-1))
                    L[i][j]=L[i-1][j-1]+1;
                else
                    L[i][j]=Math.max(L[i][j-1],L[i-1][j]);
            }
        }
        
        StringBuilder sb=new StringBuilder();
        
        int i=n, j=m;
        
        while(i>0&&j>0)
        {
            if(str1.charAt(i-1)==str2.charAt(j-1))
            {
                sb.append(str1.charAt(i-1));
                i--;
                j--;
            }
            else
            {
                if(L[i][j-1]>L[i-1][j])
                {
                    sb.append(str2.charAt(j-1));
                    j--;
                }
                else
                {
                    sb.append(str1.charAt(i-1));
                    i--;
                }
                    
            }
        }
        
        while(i>0)
        {
            sb.append(str1.charAt(i-1));
            i--;
        }
        
        while(j>0)
        {
            sb.append(str2.charAt(j-1));
            j--;
        }
        
        return sb.reverse().toString();
    }
}