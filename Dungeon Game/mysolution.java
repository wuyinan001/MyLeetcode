class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int n=dungeon.length;
        int m=dungeon[0].length;
        
        // L[i][j] min health at i,j to reach princess
        int[][] L=new int[n][m];
        
        L[n-1][m-1]=max(1,1-dungeon[n-1][m-1]);
        
        for(int i=n-2;i>=0;i--)
            L[i][m-1]=max(1,L[i+1][m-1]-dungeon[i][m-1]);
        
        for(int i=m-2;i>=0;i--)
            L[n-1][i]=max(1,L[n-1][i+1]-dungeon[n-1][i]);
        
        for(int i=n-2;i>=0;i--)
        {
            for(int j=m-2;j>=0;j--)
            {
                L[i][j]=max(1,min(L[i+1][j],L[i][j+1])-dungeon[i][j]);
            }
        }
        
        print(L);
        
        return L[0][0];
    }
    
    private void print(int[][] M)
    {
        int n=M.length;
        int m=M[0].length;
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                System.out.print(M[i][j]+"\t");
            }
            System.out.println();
        }
    }
    
    private int min(int a, int b)
    {
        if(a>b)
            return b;
        else
            return a;
    }
    
    private int max(int a, int b)
    {
        if(a>b)
            return a;
        else
            return b;
    }
}