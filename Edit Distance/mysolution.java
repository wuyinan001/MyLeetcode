class Solution {
    public int minDistance(String word1, String word2) {
        
        int n1=word1.length(), n2=word2.length();
        
        int[][] D=new int[n1+1][n2+1];
        
        for(int i=0;i<=n1;i++)
        {
            D[i][0]=i;
        }
        
        for(int i=0;i<=n2;i++)
        {
            D[0][i]=i;
        }
        
        for(int i=1;i<=n1;i++)
        {
            for(int j=1;j<=n2;j++)
            {
                if(word1.substring(i-1,i).equals(word2.substring(j-1,j)))
                {
                    D[i][j]=1+Math.min(D[i-1][j-1]-1,Math.min(D[i-1][j],D[i][j-1]));
                }
                else
                {
                    D[i][j]=1+Math.min(D[i-1][j-1],Math.min(D[i-1][j],D[i][j-1]));
                }
            }
        }
        
        return D[n1][n2];
    }
}