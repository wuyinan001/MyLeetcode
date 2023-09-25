class Solution {
    
    int n;
    int[][] dist=new int[27][27];
    
    private int dp(String word, int i, int j, int k, Integer[][][] memo)
    {
        if(memo[i][j][k]!=null)
            return memo[i][j][k];
        
        int c=word.charAt(k-1)-'A';
        
        if(i!=c&&j!=c)
            return 9999;
        
        int ans=9999;
        
        // If i is at free position, then previous i must be also at free position
        if(i==26)
        {
            for(int y=0;y<27;y++)
            {
                ans=Math.min(ans,dp(word,i,y,k-1,memo)+dist[j][y]);
            }
        }
        // If j is at free position, then previous j must be also at free position
        else if(j==26)
        {
            for(int x=0;x<27;x++)
            {
                ans=Math.min(ans,dp(word,x,j,k-1,memo)+dist[x][i]);
            }
        }
        // If neither i or j is at free position, then the previous state of i,j can be any positions
        else
        {
            for(int x=0;x<27;x++)
            {
                ans=Math.min(ans,dp(word,x,j,k-1,memo)+dist[x][i]);
            }

            for(int y=0;y<27;y++)
            {
                ans=Math.min(ans,dp(word,i,y,k-1,memo)+dist[j][y]);
            }
        }
        
        memo[i][j][k]=ans;
        
        return ans;
    }
    
    private void print(int[][] A)
    {
        int n=A.length, m=A[0].length;
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
                System.out.print(A[i][j]+"\t");
            System.out.println();
        }
    }
    
    public int minimumDistance(String word) {
        
        n=word.length();
        
        Integer[][][] memo=new Integer[27][27][n+1];
        
        for(int i=0;i<27;i++)
            for(int j=0;j<27;j++)
                memo[i][j][0]=0;
        
        for(int i=0;i<26;i++)
            for(int j=0;j<26;j++)
            {
                int xi=i/6, yi=i%6, xj=j/6, yj=j%6;
                
                dist[i][j]=Math.abs(xi-xj)+Math.abs(yi-yj);
            }
        
        int ans=Integer.MAX_VALUE;
        
        for(int i=0;i<27;i++)
            for(int j=0;j<27;j++)
                ans=Math.min(ans,dp(word,i,j,n,memo));
        
        return ans;
    }
}