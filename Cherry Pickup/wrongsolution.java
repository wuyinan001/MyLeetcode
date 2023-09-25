class Solution {
    public int cherryPickup(int[][] grid) {
        
        int n=grid.length;
        
        System.out.println("Print Grid:");
        print(grid);
        
        // L1[i][j]: the max cherries can get at i,j when moving towards n-1,n-1
        int[][] L1=new int[n][n];
        // P1[i][j]: whether it is reachable at i,j when moving towards n-1,n-1
        boolean[][] P1=new boolean[n][n];
        
        L1[0][0]=grid[0][0];
        P1[0][0]= grid[0][0]==-1 ? false : true;
        
        for(int i=1;i<n;i++)
        {
            if(P1[i-1][0]&&grid[i][0]!=-1)
            {
                P1[i][0]=true;
                L1[i][0]=L1[i-1][0]+grid[i][0];
            }
        }
        
        for(int j=1;j<n;j++)
        {
            if(P1[0][j-1]&&grid[0][j]!=-1)
            {
                P1[0][j]=true;
                L1[0][j]=L1[0][j-1]+grid[0][j];
            }
        }
        
        for(int i=1;i<n;i++)
        {
            for(int j=1;j<n;j++)
            {
                if((!P1[i-1][j]&&!P1[i][j-1])||grid[i][j]==-1)
                    continue;
                
                P1[i][j]=true;
                
                if(!P1[i-1][j])
                    L1[i][j]=grid[i][j]+L1[i][j-1];
                else if(!P1[i][j-1])
                    L1[i][j]=grid[i][j]+L1[i-1][j];
                else
                    L1[i][j]=grid[i][j]+Math.max(L1[i-1][j],L1[i][j-1]);
            }
        }
        
        if(!P1[n-1][n-1])
            return 0;
             
        // Backtrace and clear cherries on the path
        int x=n-1,y=n-1;
        
        while(x!=0||y!=0)
        {
            grid[x][y]=0;
            
            if(x==0)
            {
                y--;
            }
            else if(y==0)
            {
                x--;
            }
            else if(!P1[x-1][y])
            {
                y--;
            }
            else if(!P1[x][y-1])
            {
                x--;
            }
            else
            {
                if(L1[x-1][y]>L1[x][y-1])
                {
                    x--;
                }
                else
                {
                    y--;
                }
            }
        }
        
        grid[0][0]=0;
        
        System.out.println("Print Grid:");
        print(grid);
        
        // L2[i][j]: the max cherries can get at i,j when moving towards 0,0
        int[][] L2=new int[n][n];
        // P2[i][j]: whether it is reachable at i,j when moving towards 0,0
        boolean[][] P2=new boolean[n][n];
        
        L2[n-1][n-1]=grid[n-1][n-1];
        P2[n-1][n-1]= true;
        
        for(int i=n-2;i>=0;i--)
        {
            if(P2[i+1][n-1]&&grid[i][n-1]!=-1)
            {
                P2[i][n-1]=true;
                L2[i][n-1]=L2[i+1][n-1]+grid[i][n-1];
            }
        }
        
        for(int j=n-2;j>=0;j--)
        {
            if(P2[n-1][j+1]&&grid[n-1][j]!=-1)
            {
                P2[n-1][j]=true;
                L2[n-1][j]=L2[n-1][j+1]+grid[n-1][j];
            }
        }
        
        for(int i=n-2;i>=0;i--)
        {
            for(int j=n-2;j>=0;j--)
            {
                if((!P2[i+1][j]&&!P2[i][j+1])||grid[i][j]==-1)
                    continue;
                
                P2[i][j]=true;
                
                if(!P2[i+1][j])
                    L2[i][j]=grid[i][j]+L2[i][j+1];
                else if(!P2[i][j+1])
                    L2[i][j]=grid[i][j]+L2[i+1][j];
                else
                    L2[i][j]=grid[i][j]+Math.max(L2[i+1][j],L2[i][j+1]);
            }
        }
        
        return L1[n-1][n-1]+L2[0][0];
    }
    
    private void print(int[][] a)
    {
        int n=a.length,m=a[0].length;
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                System.out.print(a[i][j]+"\t");
            }
            System.out.println();
        }
    }
}

/* This solution fails the following case:
	Print Grid:
1	1	1	1	0	0	0	
0	0	0	1	0	0	0	
0	0	0	1	0	0	1	
1	0	0	1	0	0	0	
0	0	0	1	0	0	0	
0	0	0	1	0	0	0	
0	0	0	1	1	1	1	
*/