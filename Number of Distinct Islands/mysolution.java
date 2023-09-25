class Solution {
    public int numDistinctIslands(int[][] grid) {
        
        Set<String> set=new HashSet();
        Queue<int[]> queue=new LinkedList();
        
        int n=grid.length, m=grid[0].length;
        
        int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1)
                {
                    grid[i][j]=0;
                    queue.add(new int[]{i,j});
                    List<int[]> list=new ArrayList();
                        
                    while(!queue.isEmpty())
                    {
                        int[] temp=queue.remove();
                        list.add(temp);
                        
                        for(int k=0;k<4;k++)
                        {
                            int x=temp[0]+dir[k][0], y=temp[1]+dir[k][1];
                            if(x>=0&&x<n&&y>=0&&y<m&&grid[x][y]==1)
                            {
                                grid[x][y]=0;
                                queue.add(new int[]{x,y});
                            }
                        }
                    }
                    
                    Collections.sort(list,new Comparator<int[]>(){
                        
                        public int compare(int[] a1, int[] a2)
                        {
                            if(a1[0]==a2[0])
                                return a1[1]-a2[1];
                            return a1[0]-a2[0];
                        }
                        
                    });
                    
                    int row=list.get(0)[0], col=list.get(0)[1];
                    
                    for(int[] interval:list)
                    {
                        interval[0]-=row;
                        interval[1]-=col;
                    }
                    
                    StringBuilder sb=new StringBuilder();
                    
                    for(int[] interval:list)
                    {
                        sb.append("["+interval[0]+","+interval[1]+"],");
                    }
                    
                    set.add(sb.toString());
                }
            }
        }
        
        //print(set);
        
        return set.size();
    }
    
    private void print(Set<String> set)
    {
        int count=1;
        for(String s:set)
        {
            System.out.println("Number "+count);
            
            System.out.println(s);
            
            count++;
        }
    }
}