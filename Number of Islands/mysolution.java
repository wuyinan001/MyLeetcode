class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        
        if(n==0)
            return 0;
        
        int m=grid[0].length;
        
        if(m==0)
            return 0;
        
        int[][] marked=new int[n][m];
        Queue<Integer[]> queue=new LinkedList<>();
        
        int ans=0;
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                //printGrid(marked);
                
                if(grid[i][j]=='1'&&marked[i][j]==0)
                {
                    ans++;
                    marked[i][j]=1;
                    
                    queue.add(new Integer[]{i,j});
                    
                    while(!queue.isEmpty())
                    {
                        Integer[] coord=queue.remove();
                        int ii=coord[0],jj=coord[1];
                        
                        // Move down
                        if(ii<n-1&&grid[ii+1][jj]=='1'&&marked[ii+1][jj]==0)
                        {
                            queue.add(new Integer[]{ii+1,jj});
                            marked[ii+1][jj]=1;
                        }
                        // Move right
                        if(jj<m-1&&grid[ii][jj+1]=='1'&&marked[ii][jj+1]==0)
                        {
                            queue.add(new Integer[]{ii,jj+1});
                            marked[ii][jj+1]=1;
                        }
                        // Move up
                        if(ii>0&&grid[ii-1][jj]=='1'&&marked[ii-1][jj]==0)
                        {
                            queue.add(new Integer[]{ii-1,jj});
                            marked[ii-1][jj]=1;
                        }
                        // Move left
                        if(jj>0&&grid[ii][jj-1]=='1'&&marked[ii][jj-1]==0)
                        {
                            queue.add(new Integer[]{ii,jj-1});
                            marked[ii][jj-1]=1;
                        }
                    }
                }
            }
        }
        
        return ans;
    }
    
    private void printGrid(int[][] marked)
    {
        int n=marked.length;
        int m=marked[0].length;
        
        System.out.println("Marked:");
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                System.out.print(marked[i][j]+"\t");
            }
            System.out.println();
        }
    }
}