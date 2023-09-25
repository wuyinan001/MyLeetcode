class Solution {
    
    // dist[x][y]: distance between xth(previous) letter and yth(afterwards) letter
    // 
    int[][] dist=new int[27][27];
    
    private int dp(String word, int[][][] memo, int i, int j, int k)
    {
        if(memo[i][j][k]!=-1)
            return memo[i][j][k];
        
        int pos=word.charAt(k)-'A';
        
        if(i!=pos&&j!=pos)
        {
            memo[i][j][k]=9999;
            return 9999;
        }
        
        int ans=9999;
        
        for(int x=0;x<=26;x++)
            for(int y=0;y<=26;y++)
            {
                ans=Math.min(ans,dp(word,memo,x,y,k-1)+dist[x][i]+dist[y][j]);
            }
        
        memo[i][j][k]=ans;
        return ans;
    }
    
    public int minimumDistance(String word) {
        
        int n=word.length();
        
        // memo[i][j][k]:
        // the min steps when finishing kth letters when finger 1 at ith key and finger 2 at jth key
        // If i==26 || j==26, that finger has not been used
        int[][][] memo=new int[27][27][n];
        
        for(int i=0;i<=26;i++)
            for(int j=0;j<=26;j++)
            {
                if(i==26&&j==26)
                    dist[i][j]=0;
                else if(i==26)
                    dist[i][j]=0;
                // If i!=26 but j==26, that means a finger was on keyboard previously and not used afterwards;
                // This is not allowed
                else if(j==26)
                    dist[i][j]=9999;
                else
                    dist[i][j]=Math.abs(i/6-j/6)+Math.abs(i%6-j%6);
            }
        
        for(int k=0;k<n;k++)
            for(int i=0;i<=26;i++)
                for(int j=0;j<=26;j++)
                    memo[i][j][k]=-1;
        
        char c=word.charAt(0);
        
        for(int i=0;i<=26;i++)
            for(int j=0;j<=26;j++)
                if((c-'A')==i||(c-'A')==j)
                    memo[i][j][0]=0;
                else
                    memo[i][j][0]=9999;
        
        int min=9999;
        
        for(int i=0;i<=26;i++)
            for(int j=0;j<=26;j++)
                min=Math.min(min,dp(word,memo,i,j,n-1));
        
        //System.out.println(dp(word,memo,4,4,n-1));
                
        return min;
    }
}