class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
     
        List<List<Integer>> ans=new ArrayList<>();
        int n=matrix.length;
        
        if(n==0)
            return ans;
        
        int m=matrix[0].length;
        int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
        
        
        // P: which coordinates can flow to Pacific
        // A: which coordinates can flow to Atlantic
        boolean[][] P=new boolean[n][m];
        boolean[][] A=new boolean[n][m];
        
        Queue<int[]> queue=new LinkedList<>();
        
        for(int i=0;i<n;i++)
        {
            P[i][0]=true;
            queue.add(new int[]{i,0});
        }
        
        for(int j=1;j<m;j++)
        {
            P[0][j]=true;
            queue.add(new int[]{0,j});
        }
        
        while(!queue.isEmpty())
        {
            int[] pos=queue.remove();
            
            int x=pos[0],y=pos[1];
            
            for(int i=0;i<4;i++)
            {
                int xx=pos[0];
                int yy=pos[1];
                xx=x+dir[i][0];
                yy=y+dir[i][1];
                
                if(xx>=0&&xx<n&&yy>=0&&yy<m&&matrix[xx][yy]>=matrix[x][y]&&!P[xx][yy])
                {
                    queue.add(new int[]{xx,yy});
                    P[xx][yy]=true;
                }
            }
        }
        
        //System.out.println("P");
        //print(P);
        
        for(int i=0;i<n;i++)
        {
            A[i][m-1]=true;
            queue.add(new int[]{i,m-1});
        }
        
        for(int j=0;j<m-1;j++)
        {
            A[n-1][j]=true;
            queue.add(new int[]{n-1,j});
        }
        
        while(!queue.isEmpty())
        {
            int[] pos=queue.remove();
            
            int x=pos[0],y=pos[1];
            
            for(int i=0;i<4;i++)
            {
                int xx=pos[0];
                int yy=pos[1];
                xx=x+dir[i][0];
                yy=y+dir[i][1];
                
                if(xx>=0&&xx<n&&yy>=0&&yy<m&&matrix[xx][yy]>=matrix[x][y]&&!A[xx][yy])
                {
                    queue.add(new int[]{xx,yy});
                    A[xx][yy]=true;
                }
            }
        }
        
        //System.out.println("A");
        //print(A);
        
        // Update A by doing AND operation on P and A
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                A[i][j]=A[i][j]&P[i][j];
                if(A[i][j])
                {
                    List<Integer> a=Arrays.asList(new Integer[]{i,j});
                    ans.add(a);
                }
            }
        }
        
        //print(A);
        
        return ans;
    }
    
    private void print(boolean[][] P)
    {
        int n=P.length,m=P[0].length;
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
                System.out.print(P[i][j]+"\t");
            
            System.out.println();
        }
    }
}