class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        
        int n=maze.length;
        
        if(n==0)
            return false;
        
        int m=maze[0].length;
        
        // Mark the location when the ball stops at that location
        int[][] mark=new int[n][m];
        
        // motion: 0-Free; 1-Up; 2-Down; 3-Left; 4-Right
        int[][] motion=new int[n][m];
        
        // Mark whether the up,down,left,right directions have been tried at i,j location
        int[][] up=new int[n][m];
        int[][] down=new int[n][m];
        int[][] left=new int[n][m];
        int[][] right=new int[n][m];
        
        Queue<int[]> queue=new LinkedList<>();
        
        // state: 0-Free; 1-Up; 2-Down; 3-Left; 4-Right
        int state=0;
        
        queue.add(start);
        //mark[start[0]][start[1]]=1;
        
        while(!queue.isEmpty())
        {
            int[] pos=queue.remove();
            
            if(motion[pos[0]][pos[1]]==0)
            {
                // Move up
                if(pos[0]>0&&maze[pos[0]-1][pos[1]]==0&&up[pos[0]-1][pos[1]]==0)
                {
                    
                    up[pos[0]-1][pos[1]]=1;
                    motion[pos[0]-1][pos[1]]=1;
                    queue.add(new int[]{pos[0]-1,pos[1]});
                }

                // Move down
                if(pos[0]<n-1&&maze[pos[0]+1][pos[1]]==0&&down[pos[0]+1][pos[1]]==0)
                {
                    
                    down[pos[0]+1][pos[1]]=1;
                    motion[pos[0]+1][pos[1]]=2;
                    queue.add(new int[]{pos[0]+1,pos[1]});
                }


                // Move left
                if(pos[1]>0&&maze[pos[0]][pos[1]-1]==0&&left[pos[0]][pos[1]-1]==0)
                {
                    
                    left[pos[0]][pos[1]-1]=1;
                    motion[pos[0]][pos[1]-1]=3;
                    queue.add(new int[]{pos[0],pos[1]-1});
                }


                // Move right
                if(pos[1]<m-1&&maze[pos[0]][pos[1]+1]==0&&right[pos[0]][pos[1]+1]==0)
                {
                    
                    right[pos[0]][pos[1]+1]=1;
                    motion[pos[0]][pos[1]+1]=4;
                    queue.add(new int[]{pos[0],pos[1]+1});
                }
            }
            else if(motion[pos[0]][pos[1]]==1)
            {
                // Move up
                if(pos[0]>0&&maze[pos[0]-1][pos[1]]==0&&up[pos[0]-1][pos[1]]==0)
                {
                    up[pos[0]-1][pos[1]]=1;
                    motion[pos[0]-1][pos[1]]=1;
                    queue.add(new int[]{pos[0]-1,pos[1]});
                }
                else
                {
                    // Stop at the wall
                    mark[pos[0]][pos[1]]=1;
                    // Move down
                    if(pos[0]<n-1&&maze[pos[0]+1][pos[1]]==0&&down[pos[0]+1][pos[1]]==0)
                    {
                        
                        down[pos[0]+1][pos[1]]=1;
                        motion[pos[0]+1][pos[1]]=2;
                        queue.add(new int[]{pos[0]+1,pos[1]});
                    }


                    // Move left
                    if(pos[1]>0&&maze[pos[0]][pos[1]-1]==0&&left[pos[0]][pos[1]-1]==0)
                    {
                        
                        left[pos[0]][pos[1]-1]=1;
                        motion[pos[0]][pos[1]-1]=3;
                        queue.add(new int[]{pos[0],pos[1]-1});
                    }


                    // Move right
                    if(pos[1]<m-1&&maze[pos[0]][pos[1]+1]==0&&right[pos[0]][pos[1]+1]==0)
                    {
                        
                        right[pos[0]][pos[1]+1]=1;
                        motion[pos[0]][pos[1]+1]=4;
                        queue.add(new int[]{pos[0],pos[1]+1});
                    }
                }
            } 
            else if(motion[pos[0]][pos[1]]==2)
            {
                // Move down
                if(pos[0]<n-1&&maze[pos[0]+1][pos[1]]==0&&down[pos[0]+1][pos[1]]==0)
                {
                    
                    down[pos[0]+1][pos[1]]=1;
                    motion[pos[0]+1][pos[1]]=2;
                    queue.add(new int[]{pos[0]+1,pos[1]});
                }
                else
                {
                    // Stop at the wall
                    mark[pos[0]][pos[1]]=1;
                    // Move up
                    if(pos[0]>0&&maze[pos[0]-1][pos[1]]==0&&up[pos[0]-1][pos[1]]==0)
                    {
                        
                        up[pos[0]-1][pos[1]]=1;
                        motion[pos[0]-1][pos[1]]=1;
                        queue.add(new int[]{pos[0]-1,pos[1]});
                    }
                    
                    // Move left
                    if(pos[1]>0&&maze[pos[0]][pos[1]-1]==0&&left[pos[0]][pos[1]-1]==0)
                    {
                        
                        left[pos[0]][pos[1]-1]=1;
                        motion[pos[0]][pos[1]-1]=3;
                        queue.add(new int[]{pos[0],pos[1]-1});
                    }


                    // Move right
                    if(pos[1]<m-1&&maze[pos[0]][pos[1]+1]==0&&right[pos[0]][pos[1]+1]==0)
                    {
                        
                        right[pos[0]][pos[1]+1]=1;
                        motion[pos[0]][pos[1]+1]=4;
                        queue.add(new int[]{pos[0],pos[1]+1});
                    }
                }
            } 
            else if(motion[pos[0]][pos[1]]==3)
            {
                // Move left
                if(pos[1]>0&&maze[pos[0]][pos[1]-1]==0&&left[pos[0]][pos[1]-1]==0)
                {
                    
                    left[pos[0]][pos[1]-1]=1;
                    motion[pos[0]][pos[1]-1]=3;
                    queue.add(new int[]{pos[0],pos[1]-1});
                }
                else
                {
                    // Stop at the wall
                    mark[pos[0]][pos[1]]=1;
                    // Move up
                    if(pos[0]>0&&maze[pos[0]-1][pos[1]]==0&&up[pos[0]-1][pos[1]]==0)
                    {
                        
                        up[pos[0]-1][pos[1]]=1;
                        motion[pos[0]-1][pos[1]]=1;
                        queue.add(new int[]{pos[0]-1,pos[1]});
                    }
                    
                    // Move down
                    if(pos[0]<n-1&&maze[pos[0]+1][pos[1]]==0&&down[pos[0]+1][pos[1]]==0)
                    {
                        
                        down[pos[0]+1][pos[1]]=1;
                        motion[pos[0]+1][pos[1]]=2;
                        queue.add(new int[]{pos[0]+1,pos[1]});
                    }


                    // Move right
                    if(pos[1]<m-1&&maze[pos[0]][pos[1]+1]==0&&right[pos[0]][pos[1]+1]==0)
                    {
                        
                        right[pos[0]][pos[1]+1]=1;
                        motion[pos[0]][pos[1]+1]=4;
                        queue.add(new int[]{pos[0],pos[1]+1});
                    }
                }
            }
            else
            {
                 // Move right
                if(pos[1]<m-1&&maze[pos[0]][pos[1]+1]==0&&right[pos[0]][pos[1]+1]==0)
                {
                    
                    right[pos[0]][pos[1]+1]=1;
                    motion[pos[0]][pos[1]+1]=4;
                    queue.add(new int[]{pos[0],pos[1]+1});
                }
                else
                {
                    // Stop at the wall
                    mark[pos[0]][pos[1]]=1;
                    // Move up
                    if(pos[0]>0&&maze[pos[0]-1][pos[1]]==0&&up[pos[0]-1][pos[1]]==0)
                    {
                        //mark[pos[0]-1][pos[1]]=1;
                        up[pos[0]-1][pos[1]]=1;
                        motion[pos[0]-1][pos[1]]=1;
                        queue.add(new int[]{pos[0]-1,pos[1]});
                    }
                    
                    // Move down
                    if(pos[0]<n-1&&maze[pos[0]+1][pos[1]]==0&&down[pos[0]+1][pos[1]]==0)
                    {
                        down[pos[0]+1][pos[1]]=1;
                        motion[pos[0]+1][pos[1]]=2;
                        queue.add(new int[]{pos[0]+1,pos[1]});
                    }


                    // Move left
                    if(pos[1]>0&&maze[pos[0]][pos[1]-1]==0&&left[pos[0]][pos[1]-1]==0)
                    {
                        left[pos[0]][pos[1]-1]=1;
                        motion[pos[0]][pos[1]-1]=3;
                        queue.add(new int[]{pos[0],pos[1]-1});
                    }
                }
            }
        }
        
        //print(mark);
        
        if(mark[destination[0]][destination[1]]==1)
            return true;
        else
            return false;
    }
    
    
    private void print(int[][] a)
    {
        int n=a.length;
        int m=a[0].length;
        
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