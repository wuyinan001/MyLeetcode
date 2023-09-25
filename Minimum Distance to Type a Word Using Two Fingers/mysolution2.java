class Solution {
    
    // Distance array
    int[][] dist=new int[27][27];
    
    // memo[i][j][k]: min distance to type the kth char when finger 1 at position i and finger 2 at position j
    // If i,j==26, that means finger 1 or finger 2 has not been used yet
    // If neither of finger is at position of kth char, then return inf or 9999
    // If at least one finger is at position of kth char, then 
    
    // If i is in position: memo[i][j][k]=Min(memo[ii][j][k-1]+dist(i,ii))
    // If j is in position: memo[i][j][k]=Min(memo[i][jj][k-1]+dist(j,jj))
    
    private int dp(String word, int i, int j, int k, int[][][] memo)
    {
        if(memo[i][j][k]!=-1)
            return memo[i][j][k];
        
        // current char position
        int pos=word.charAt(k)-'A';
        
        if(i!=pos&&j!=pos)
        {
            memo[i][j][k]=9999;
            return memo[i][j][k];
        }
        
        if(k==0)
            return 0;
        
        int min=9999;
        
        if(i==pos)
        {
            for(int ii=0;ii<=26;ii++)
            {
                min=Math.min(min,dp(word,ii,j,k-1,memo)+dist[i][ii]);
            }
        }
        
        if(j==pos)
        {
            for(int jj=0;jj<=26;jj++)
            {
                min=Math.min(min,dp(word,i,jj,k-1,memo)+dist[j][jj]);
            }
        }
        
        memo[i][j][k]=min;
        return min;
    }
    
    public int minimumDistance(String word) {
        
        int n=word.length();
        int[][][] memo=new int[27][27][n];
        
        for(int i=0;i<=26;i++)
            for(int j=0;j<=26;j++)
                for(int k=0;k<n;k++)
                    memo[i][j][k]=-1;
        
        // Need at least one finger on the keyboard, otherwise it takes inf distance to type the key
        for(int k=0;k<n;k++)
            memo[26][26][k]=9999;
        
        // Compute dist array
        // Distance of position x to position y
        // If x or y is 26, that means the finger has not been used yet, then the distance is 0;
        // Otherwise return the |x1-x2|+|y1-y2|
        for(int i=0;i<=26;i++)
            for(int j=0;j<=26;j++)
            {
                if(i!=26&&j!=26)
                    dist[i][j]=Math.abs(i/6-j/6)+Math.abs(i%6-j%6);
            }
        
        int min=9999;
        
        for(int i=0;i<=26;i++)
            for(int j=0;j<=26;j++)
                min=Math.min(min,dp(word,i,j,n-1,memo));
       
        return min;
    }
}